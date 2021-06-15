package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionMissionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.ActionMissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionMissionService implements IActionMissionService {

    @Autowired
    private ActionMissionRepository actionMissionRepository;

    @Override
    public List<ActionMissionEntity> getToutesLesActionMissions() {

            List<ActionMissionEntity> mesActionMissions=null;
            try {

                mesActionMissions= actionMissionRepository.findAll();
            } catch (Exception e) {
                throw new MonException("Insert", "Sql", e.getMessage());
            }
            return mesActionMissions;
        }


    /*public ActionMissionEntity getActionMissionID(int id) {
        return actionMissionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }*/

    public List<ActionMissionEntity> getActionMissionsByAction(int id){
        return actionMissionRepository.findByIdAction(id);
    }

    public List<ActionMissionEntity> getActionMissionsByMission(int id){
        return actionMissionRepository.findByIdMission(id);
    }

    public ActionMissionEntity getActionMissionsByActionMission(int idAction, int idMission){
        return actionMissionRepository.findByIdActionMission(idAction, idMission);
    }

    public List<ActionMissionEntity> getMissionsSansAction(int id){
        return actionMissionRepository.findActionsSansMissionId(id);
    }
    
    @Override
    public void ajouterActionMission(ActionMissionEntity actionMission) {
        try {
            actionMissionRepository.save(actionMission);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    @Override
    public void updateActionMission(ActionMissionEntity actionMission){
        try{
            actionMissionRepository.save(actionMission);
        } catch (Exception e) {
            throw new MonException("Update", "Sql", e.getMessage());
        }
    }

    public void supprimerActionMission(ActionMissionEntity actionMission){
        try{
            actionMissionRepository.delete(actionMission);
        } catch (Exception e) {
            throw new MonException("Delete", "Sql", e.getMessage());
        }
    }

}
