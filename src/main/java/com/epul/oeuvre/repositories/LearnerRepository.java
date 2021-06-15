package com.epul.oeuvre.repositories;


import com.epul.oeuvre.domains.LearnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepository extends JpaRepository<LearnerEntity, Integer> {

    public LearnerEntity rechercheNom(String login);

}

