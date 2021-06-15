package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.JeuEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RequestMapping("/jeu")
@RestController
@CrossOrigin
public class ControllerJeu {
    
    @Autowired
    private JeuService jeuService;

/*************************************************/
/**************Tous les jeus  ******************/
    /*************************************************/
    @RequestMapping(method = RequestMethod.GET, value = "/getJeux")
    public ModelAndView getJeus(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        String destinationPage = "";
        List<JeuEntity> mesJeus = null;
        try {
            mesJeus = jeuService.getToutesLesJeux();
            request.setAttribute("mesJeus", mesJeus);
            destinationPage = "views/listerJeu";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "views/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

   /* private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "nomJeu");
    }*/

    @RequestMapping(value = "/getUnJeu/{id}\"", method = RequestMethod.GET)
    public JeuEntity getJeuById(@PathVariable(value = "id") int id) {
        JeuEntity unAd = null;
        try {
            unAd = jeuService.getJeuID(id);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return unAd;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/insererJeu")
    public ModelAndView insererJeu(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            JeuEntity unJeu = new JeuEntity();
            jeuService.ajouterJeu(unJeu);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifier")
    public ModelAndView modifierJeu(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String destinationPage = "";
        JeuEntity unJeu = jeuService.getJeuID(Integer.parseInt(request.getParameter("idJeu")));
        jeuService.updateJeu(unJeu);
        destinationPage = "index";

        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/ajout")
    public ModelAndView ajouterJeu(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "views/ajouterJeu";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/learner/{id}")
    public ModelAndView getJeuxByLearner(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) {
        String destinationPage = "";
        List<JeuEntity> jeux = jeuService.getJeuxByLearner(id);
        request.setAttribute("mesJeux", jeux);
        destinationPage = "views/listerJeu";
        return new ModelAndView(destinationPage);
    }

    /*@RequestMapping(value = "/ajouterMission/{id}")
    public ModelAndView ajouterMission(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) {
        String destinationPage = "";
        List<MissionEntity> missions = missionService.getToutesLesMissions();
        List<JeuMissionEntity> am = jeuMissionService.getJeuMissionsByJeu(id);
        for (MissionEntity m :
                missions) {
            for (JeuMissionEntity a :
                    am) {
                if (m.getId() == a.getFkMission()) {
                    missions.remove(m);
                }
            }
        }
        request.setAttribute("missions", missions);
        request.setAttribute("id", id);
        destinationPage = "views/ajouterMissionJeu";
        return new ModelAndView(destinationPage);
    }*/

}

