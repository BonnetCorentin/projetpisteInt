package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.*;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/action")
@RestController
@CrossOrigin
public class ControllerAction {

    @Autowired
    private ActionService actionService;
    @Autowired
    private MissionService missionService;
    @Autowired
    private ActionMissionService actionMissionService;
    @Autowired
    private InscriptionActionService inscriptionActionService;
    @Autowired
    private InscriptionService inscriptionService;

/*************************************************/
/**************Tous les actions  ******************/
    /*************************************************/
    @RequestMapping(method = RequestMethod.GET, value = "/getActions")
    public ModelAndView getActions(HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        String destinationPage = "";
        List<ActionEntity> mesActions = null;
        try {
            mesActions = actionService.getToutesLesActions();
            request.setAttribute("mesActions", mesActions);
            destinationPage = "vues/listerAction";
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
        return new Sort(Sort.Direction.ASC, "nomAction");
    }*/

    @RequestMapping(value = "/getUnAction/{id}\"", method = RequestMethod.GET)
    public ActionEntity getActionById(@PathVariable(value = "id") int id) {
        ActionEntity unAd = null;
        try {
            unAd = actionService.getActionID(id);
        } catch (MonException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return unAd;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/insererAction")
    public ModelAndView insererAction(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            ActionEntity unAction = new ActionEntity();
            unAction.setWording(request.getParameter("wording"));
            unAction.setScoreMinimum(Integer.valueOf(request.getParameter("scoreMinimum")));
            actionService.ajouterAction(unAction);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifier")
    public ModelAndView modifierAction(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        String destinationPage = "";
        ActionEntity unAction = actionService.getActionID(Integer.parseInt(request.getParameter("idAction")));
        unAction.setWording(request.getParameter("wording"));
        unAction.setScoreMinimum(Integer.valueOf(request.getParameter("scoreMinimum")));
        actionService.updateAction(unAction);
        destinationPage = "index";

        return new ModelAndView(destinationPage);
    }


    @RequestMapping(value = "/ajout")
    public ModelAndView ajouterAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            destinationPage = "views/ajouterAction";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/getActions/learner/{id}")
    public ModelAndView getActionsByLearner(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) {
        String destinationPage = "";
        List<InscriptionEntity> inscriptions = inscriptionService.getInscriptionsByLearner(id);
        List<InscriptionActionEntity> inscriptionsAction = inscriptionActionService.getInscriptionsAByInscription(inscriptions);
        List<ActionEntity> actions = new ArrayList<>();
        for(InscriptionActionEntity ia : inscriptionsAction){
            actions.add(actionService.getActionID(ia.getFkAction()));
        }
        request.setAttribute("mesActions", actions);
        destinationPage = "vues/listerAction";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/ajouterMission/{id}")
    public ModelAndView ajouterMission(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) {
        String destinationPage = "";
        List<MissionEntity> missions = missionService.getToutesLesMissions();
        List<ActionMissionEntity> am = actionMissionService.getActionMissionsByAction(id);
        for (MissionEntity m :
                missions) {
            for (ActionMissionEntity a :
                    am) {
                if (m.getId() == a.getFkMission()) {
                    missions.remove(m);
                }
            }
        }
        request.setAttribute("missions", missions);
        request.setAttribute("id", id);
        destinationPage = "vues/ajouterMissionAction";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping( method = RequestMethod.POST ,value ="/insererMissionAction")
    public ModelAndView insererMissionAction(HttpServletRequest request,
                                             HttpServletResponse response) throws Exception {

        String destinationPage = "";
        try {
            ActionMissionEntity unActionM = new ActionMissionEntity();
            unActionM.setFkAction(Integer.parseInt(request.getParameter("idAction")));
            unActionM.setFkMission(Integer.parseInt(request.getParameter("mission")));
            actionMissionService.ajouterActionMission(unActionM);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/{id}/getActions")
    public ModelAndView getMissionsByAction(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) {
        String destinationPage = "";
        MissionEntity mission = missionService.getMissionID(id);
        List<ActionMissionEntity> actionMissionEntities = actionMissionService.getActionMissionsByMission(id);
        List<ActionEntity> actions = new ArrayList<>();
        for (ActionMissionEntity am : actionMissionEntities) {
            actions.add(actionService.getActionID(am.getFkAction()));
        }
        request.setAttribute("mesActions", actions);
        request.setAttribute("mission", mission);
        destinationPage = "vues/listerActionMission";
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(value = "/modifierAction/{id}")
    public ModelAndView modifier(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") int id) throws Exception {
        String destinationPage = "";
        try {
            ActionEntity unAction = actionService.getActionID(id);
            request.setAttribute("monAction", unAction);
            destinationPage = "views/modifierAction";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        return new ModelAndView(destinationPage);
    }


    @GetMapping(value = "/supprimerAction/{id}")
    public ModelAndView supprimerAction(HttpServletRequest request, @PathVariable int id) {
        String destinationPage = "";
        try {
            ActionEntity unAction = actionService.getActionID(id);
            actionService.supprimerAction(unAction);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }
}

