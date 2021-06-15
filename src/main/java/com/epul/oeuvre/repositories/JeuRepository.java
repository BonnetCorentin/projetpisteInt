package com.epul.oeuvre.repositories;


import com.epul.oeuvre.domains.JeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JeuRepository extends JpaRepository<JeuEntity, Integer> {

    @Query("SELECT i FROM JeuEntity i where i.fkLearner = :idLearner")
    public List<JeuEntity> findByIdLearner(@Param("idLearner")int idLearner);

}

