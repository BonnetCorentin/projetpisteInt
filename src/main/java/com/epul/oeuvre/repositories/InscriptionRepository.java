package com.epul.oeuvre.repositories;


import com.epul.oeuvre.domains.InscriptionEntity;
import com.epul.oeuvre.domains.LearnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Integer> {

    @Query("SELECT i FROM InscriptionEntity i where i.fkLearner = :idLearner")
    public List<InscriptionEntity> findByIdLearner(@Param("idLearner")int idLearner);

    @Query("SELECT i FROM InscriptionEntity i where i.fkLearner = :idLearner and i.fkMission = :idMission")
    public List<InscriptionEntity> findByIdLearnerMission(@Param("idLearner")int idLearner, @Param("idMission")int idMission);
}

