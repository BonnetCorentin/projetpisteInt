package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService implements IActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public List<ActionEntity> getToutesLesActions() {

            List<ActionEntity> mesActions=null;
            try {

                mesActions= actionRepository.findAll();
            } catch (Exception e) {
                throw new MonException("Insert", "Sql", e.getMessage());
            }
            return mesActions;
        }


    public ActionEntity getActionID(int id) {
        return actionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }
    
    @Override
    public void ajouterAction(ActionEntity action) {
        try {
            actionRepository.save(action);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    @Override
    public void updateAction(ActionEntity action){
        try{
            actionRepository.save(action);
        } catch (Exception e) {
            throw new MonException("Update", "Sql", e.getMessage());
        }
    }

    public void supprimerAction(ActionEntity action){
        try{
            actionRepository.delete(action);
        } catch (Exception e) {
            throw new MonException("Delete", "Sql", e.getMessage());
        }
    }

}
