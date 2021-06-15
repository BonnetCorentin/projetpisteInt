package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.LearnerEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerService implements ILearnerService {

    @Autowired
    private LearnerRepository unLearnerRepository;

    private Sort sortByNom() {
        return new Sort(Sort.Direction.ASC, "surname");
    }
    // on liste tous les adhérents au format json
    @Override
    public List<LearnerEntity> getTousLesLearners() {

            List<LearnerEntity> mesLearners=null;
            try {

                mesLearners= unLearnerRepository.findAll();
            } catch (Exception e) {
                throw new MonException("Insert", "Sql", e.getMessage());
            }
            return mesLearners;
        }


    public LearnerEntity getUnLearnerID(int id) {
        return unLearnerRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

    // on insère un adhérent
    @Override
    public void ajouterClient(LearnerEntity learner) {
        try {
            unLearnerRepository.save(learner);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    @Override
    public void updateLearner(LearnerEntity learner){
        try{
            unLearnerRepository.save(learner);
        } catch (Exception e) {
            throw new MonException("Update", "Sql", e.getMessage());
        }
    }

    public void supprimerLearner(LearnerEntity learner){
        try{
            unLearnerRepository.delete(learner);
        } catch (Exception e) {
            throw new MonException("Delete", "Sql", e.getMessage());
        }
    }

}
