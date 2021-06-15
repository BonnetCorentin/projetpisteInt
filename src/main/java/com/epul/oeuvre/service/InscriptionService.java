package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.InscriptionEntity;
import com.epul.oeuvre.domains.LearnerEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService implements IInscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Override
    public List<InscriptionEntity> getToutesLesInscriptions() {

            List<InscriptionEntity> mesInscriptions=null;
            try {

                mesInscriptions= inscriptionRepository.findAll();
            } catch (Exception e) {
                throw new MonException("Insert", "Sql", e.getMessage());
            }
            return mesInscriptions;
        }


    public InscriptionEntity getInscriptionID(int id) {
        return inscriptionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

    public List<InscriptionEntity> getInscriptionsByLearner(int id){
        return inscriptionRepository.findByIdLearner(id);
    }

    public List<InscriptionEntity> getInscriptionsByLearnerMission(int idLearner, int idMission){
        return inscriptionRepository.findByIdLearnerMission(idLearner, idMission);
    }
    
    @Override
    public void ajouterInscription(InscriptionEntity inscription) {
        try {
            inscriptionRepository.save(inscription);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    @Override
    public void updateInscription(InscriptionEntity inscription){
        try{
            inscriptionRepository.save(inscription);
        } catch (Exception e) {
            throw new MonException("Update", "Sql", e.getMessage());
        }
    }

    public void supprimerInscription(InscriptionEntity inscription){
        try{
            inscriptionRepository.delete(inscription);
        } catch (Exception e) {
            throw new MonException("Delete", "Sql", e.getMessage());
        }
    }

}
