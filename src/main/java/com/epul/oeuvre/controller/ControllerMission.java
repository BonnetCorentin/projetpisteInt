package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.*;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.*;
import com.epul.oeuvre.utilitaires.MonMotPassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;


@RequestMapping("/mission")
@RestController
@CrossOrigin
public class ControllerMission {

    @Autowired
    private MissionService missionService;
    @Autowired
    private InscriptionService inscriptionService;
    @Autowired
    private ActionMissionService actionMissionService;
    @Autowired
    private ActionService actionService;
    @Autowired
    private JeuService jeuService;

/*************************************************/
/**************Tous les missions  ******************/
    /*************************************************/
    @RequestMapping(method = RequestMethod.GET, value = "/getMissions")
    public ModelAndView getMissions(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        String destinationPage = "";
        List<MissionEntity> mesMissions = null;
        try {
            mesMissions = missionService.getToutesLesMissions();
            request.setAttribute("mesMissions", mesMissions);
            destinationPage = "views/listerMission";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "views/Erreur";
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/passerTest/{idMission}/{idLearner}")
    public ModelAndView passerTest(HttpServletRequest request,
                                   HttpServletResponse response, @PathVariable(value = "idMission") int idMission, @PathVariable(value = "idLearner") int idLearner) throws Exception {

        String destinationPage = "";
        List<ActionMissionEntity> mesActionsParMission = new ArrayList<>();
        List<ActionEntity> listAction = new ArrayList<>();


        mesActionsParMission = actionMissionService.getActionMissionsByMission(idMission);
        List<Integer> score = new ArrayList<>();
        for (ActionMissionEntity a : mesActionsParMission) {
            listAction.add(a.getActionByFkAction());
            Random random = new Random();

            score.add(random.nextInt(15));
            InscriptionActionEntity i = new InscriptionActionEntity();
            i.setFkAction(a.getFkAction());
            i.setScore(score.get(score.size() - 1));
            i.setFkInscription(inscriptionService.getInscriptionsByLearnerMission(idLearner, idMission).get(0).getId());
        }

        JeuEntity jeuEntity = new JeuEntity();


        jeuEntity.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        jeuEntity.setFkLearner(idLearner);
        jeuEntity.setFkMission(idMission);
        jeuEntity.setMission(missionService.getMissionID(idMission));
        int scoreT = 0;
        for (int i = 0; i < score.size(); i++) {
            scoreT += score.get(i);
        }
        jeuEntity.setScoreTotal(scoreT);
        jeuService.ajouterJeu(jeuEntity);
        request.setAttribute("scoreT", scoreT);

        destinationPage = "index";

        return new ModelAndView(destinationPage);
    }





   /* private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "nomMission");
    }*/

    @RequestMapping(value = "/getUnMission/{id}", method = RequestMethod.GET)
    public MissionEntity getMissionById(@PathVariable(value = "id") int id) {
        MissionEntity unAd = null;
        try {
            unAd = missionService.getMissionID(id);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return unAd;
    }


    @RequestMapping(value = "/sinscrireMission/{idLearner}/{id}", method = RequestMethod.GET)
    public ModelAndView sinscrireMission(@PathVariable(value = "id") int id, @PathVariable(value = "idLearner") int idLearner) {
        String destinationPage = "";

        try {
            InscriptionEntity uneInscription = new InscriptionEntity();
            uneInscription.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

            uneInscription.setFkMission(id);
            uneInscription.setFkLearner(idLearner);

            inscriptionService.ajouterInscription(uneInscription);
            destinationPage = "index";

        } catch (Exception e) {
            throw e;
        }
        return new ModelAndView(destinationPage);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/insererMission")
    public ModelAndView insererMission(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            MissionEntity unMission = new MissionEntity();
            unMission.setWording(request.getParameter("wording"));
            missionService.ajouterMission(unMission);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifier")
    public ModelAndView modifierMission(HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        String destinationPage = "";
        MissionEntity unMission = missionService.getMissionID(Integer.parseInt(request.getParameter("idMission")));
        unMission.setWording(request.getParameter("wording"));
        missionService.updateMission(unMission);
        destinationPage = "index";

        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/ajout")
    public ModelAndView ajouterMission(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "views/ajouterMission";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/modifierMission/{id}")
    public ModelAndView modifier(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) throws Exception {
        String destinationPage = "";
        try {
            MissionEntity unMission = missionService.getMissionID(id);
            request.setAttribute("maMission", unMission);
            destinationPage = "views/modifierMission";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/getMissions/learner/{id}")
    public ModelAndView getMissionsByLearner(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) {
        String destinationPage = "";
        List<InscriptionEntity> inscriptions = inscriptionService.getInscriptionsByLearner(id);
        List<MissionEntity> missions = new ArrayList<>();
        for (InscriptionEntity inscription : inscriptions) {
            missions.add(missionService.getMissionID(inscription.getFkMission()));
        }
        request.setAttribute("mesMissions", missions);
        destinationPage = "views/listerMission";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/getMesMissions/learner/{id}")
    public ModelAndView getMesMissions(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) {
        String destinationPage = "";
        List<InscriptionEntity> inscriptions = inscriptionService.getInscriptionsByLearner(id);
        List<MissionEntity> missions = new ArrayList<>();
        for (InscriptionEntity inscription : inscriptions) {
            missions.add(missionService.getMissionID(inscription.getFkMission()));
        }
        request.setAttribute("mesMissions", missions);
        destinationPage = "views/listerMesMissions";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/getMissions/action/{id}")
    public ModelAndView getMissionsByAction(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) {
        String destinationPage = "";
        ActionEntity action = actionService.getActionID(id);
        List<ActionMissionEntity> actionMissionEntities = actionMissionService.getActionMissionsByAction(id);
        List<MissionEntity> missions = new ArrayList<>();
        for (ActionMissionEntity am : actionMissionEntities) {
            missions.add(missionService.getMissionID(am.getFkMission()));
        }
        request.setAttribute("mesMissions", missions);
        request.setAttribute("action", action);
        destinationPage = "views/listerActionMission";
        return new ModelAndView(destinationPage);
    }


    @GetMapping(value = "/supprimerMission/{id}")
    public ModelAndView supprimerMission(HttpServletRequest request, @PathVariable int id) {
        String destinationPage = "";
        try {
            MissionEntity unMission = missionService.getMissionID(id);
            missionService.supprimerMission(unMission);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        }
        return new ModelAndView(destinationPage);
    }

    @GetMapping(value = "/supprimerMission/{id}/action/{idAction}")
    public ModelAndView supprimerMissionAction(HttpServletRequest request, @PathVariable int id, @PathVariable int idAction) {
        String destinationPage = "";
        try {
            ActionMissionEntity actionMission = actionMissionService.getActionMissionsByActionMission(idAction, id);
            actionMissionService.supprimerActionMission(actionMission);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        }
        return new ModelAndView(destinationPage);
    }
}

