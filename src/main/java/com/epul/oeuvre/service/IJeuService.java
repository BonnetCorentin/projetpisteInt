package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.JeuEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IJeuService {


    public List<JeuEntity> getToutesLesJeux();

    public JeuEntity getJeuID(int id);

    public void ajouterJeu(JeuEntity unC);

    public void updateJeu(JeuEntity learner);

}