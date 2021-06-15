package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.JeuEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuService implements IJeuService {

    @Autowired
    private JeuRepository jeuRepository;

    @Override
    public List<JeuEntity> getToutesLesJeux() {

            List<JeuEntity> mesJeus=null;
            try {

                mesJeus= jeuRepository.findAll();
            } catch (Exception e) {
                throw new MonException("Insert", "Sql", e.getMessage());
            }
            return mesJeus;
        }


    public JeuEntity getJeuID(int id) {
        return jeuRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }
    
    @Override
    public void ajouterJeu(JeuEntity jeu) {
        try {
            jeuRepository.save(jeu);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    public List<JeuEntity> getJeuxByLearner(int id) {
        return jeuRepository.findByIdLearner(id);
    }

    @Override
    public void updateJeu(JeuEntity jeu){
        try{
            jeuRepository.save(jeu);
        } catch (Exception e) {
            throw new MonException("Update", "Sql", e.getMessage());
        }
    }

    public void supprimerJeu(JeuEntity jeu){
        try{
            jeuRepository.delete(jeu);
        } catch (Exception e) {
            throw new MonException("Delete", "Sql", e.getMessage());
        }
    }

}
