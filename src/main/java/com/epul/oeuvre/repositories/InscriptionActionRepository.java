package com.epul.oeuvre.repositories;


import com.epul.oeuvre.domains.InscriptionActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionActionRepository extends JpaRepository<InscriptionActionEntity, Integer> {

    @Query("SELECT i FROM InscriptionActionEntity i where i.fkInscription = :idInscription")
    public List<InscriptionActionEntity> findByIdInscription(@Param("idInscription")int idInscription);
}

