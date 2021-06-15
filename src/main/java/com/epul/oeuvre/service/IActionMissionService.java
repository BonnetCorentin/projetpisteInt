package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionMissionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IActionMissionService {


    public List<ActionMissionEntity> getToutesLesActionMissions();

    //public ActionMissionEntity getActionMissionID(int id);

    public void ajouterActionMission(ActionMissionEntity unC);

    public void updateActionMission(ActionMissionEntity actionM);

    public void supprimerActionMission(ActionMissionEntity actionM);

}