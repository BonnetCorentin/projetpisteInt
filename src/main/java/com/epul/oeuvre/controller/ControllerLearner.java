package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.LearnerEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.LearnerService;
import com.epul.oeuvre.utilitaires.MonMotPassHash;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


@RequestMapping("/learner")
@RestController
@CrossOrigin
public class ControllerLearner {

    @Autowired
    private LearnerService unLearnerService;

/*************************************************/
/**************Tous les learners  ******************/
    /*************************************************/
    @RequestMapping(method = RequestMethod.GET, value = "/getLearners")
    public ModelAndView getLearners(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        String destinationPage = "";
        List<LearnerEntity> mesLearners = null;
        try {
            mesLearners = unLearnerService.getTousLesLearners();
            request.setAttribute("mesLearners", mesLearners);
            destinationPage = "views/listerLearner";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

   /* private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "nomLearner");
    }*/

    @RequestMapping(value = "/getUnLearner/{id}\"", method = RequestMethod.GET)
    public LearnerEntity getLearnerById(@PathVariable(value = "id") int id) {
        LearnerEntity unAd = null;
        try {
            unAd = unLearnerService.getUnLearnerID(id);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return unAd;
    }





    @RequestMapping(method = RequestMethod.POST, value = "/insererLearner")
    public ModelAndView insererLearner(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            LearnerEntity unLearner = new LearnerEntity();
            unLearner.setForname(request.getParameterValues("prenom")[0]);
            unLearner.setSurname(request.getParameterValues("nom")[0]);
            unLearner.setEmail(request.getParameterValues("email")[0]);
            unLearner.setRole("apprenant");
            unLearner.setMdp(request.getParameterValues("mdp")[0]);
            unLearner.setSalt(MonMotPassHash.bytesToString(MonMotPassHash.GenerateSalt()));
            byte[] salt = MonMotPassHash.transformeEnBytes(unLearner.getSalt());
            char[] mdp = MonMotPassHash.converttoCharArray(unLearner.getMdp());
            unLearner.setMdp(MonMotPassHash.bytesToString(MonMotPassHash.generatePasswordHash(mdp, salt)));
            unLearnerService.ajouterClient(unLearner);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifier")
    public ModelAndView modifierLearner(HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        String destinationPage = "";
        LearnerEntity unLearner = unLearnerService.getUnLearnerID(Integer.parseInt(request.getParameter("idLearner")));
        unLearner.setForname(request.getParameterValues("prenom")[0]);
        unLearner.setSurname(request.getParameterValues("nom")[0]);
        unLearner.setEmail(request.getParameterValues("email")[0]);
        unLearnerService.updateLearner(unLearner);
        destinationPage = "index";

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "afficherLearner/{id}")
    public ModelAndView afficherLearner(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) throws Exception {
        String destinationPage = "vues/learnerDashboard";

        LearnerEntity learnerEntity = getLearnerById(id);

        request.setAttribute("learner", learnerEntity);


        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/ajout")
    public ModelAndView ajouterLearner(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "views/ajouterLearner";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/modifierLearner/{id}")
    public ModelAndView modifier(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) throws Exception {
        String destinationPage = "";
        try {
            LearnerEntity unLearner = unLearnerService.getUnLearnerID(id);
            request.setAttribute("monLearner", unLearner);
            destinationPage = "views/modifierLearner";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @GetMapping(value = "/supprimerLearner/{id}")
    public ModelAndView supprimerLearner(HttpServletRequest request, @PathVariable int id) {
        String destinationPage = "";
        try {
            LearnerEntity unLearner = unLearnerService.getUnLearnerID(id);
            unLearnerService.supprimerLearner(unLearner);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }
}

