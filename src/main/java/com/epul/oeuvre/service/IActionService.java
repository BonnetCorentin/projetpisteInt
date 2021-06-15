package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.ActionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IActionService {


    public List<ActionEntity> getToutesLesActions();

    public ActionEntity getActionID(int id);

    public void ajouterAction(ActionEntity unC);

    public void updateAction(ActionEntity learner);

}