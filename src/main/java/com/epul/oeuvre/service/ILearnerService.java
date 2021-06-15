package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.LearnerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface ILearnerService {


    public List<LearnerEntity> getTousLesLearners();

    public LearnerEntity getUnLearnerID(int id);

    public void ajouterClient(LearnerEntity unC);

    public void updateLearner(LearnerEntity learner);

}