package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.InscriptionActionEntity;
import com.epul.oeuvre.domains.InscriptionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.InscriptionActionRepository;
import com.epul.oeuvre.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InscriptionActionService implements IInscriptionActionService {

    @Autowired
    private InscriptionActionRepository inscriptionActionRepository;

    @Override
    public List<InscriptionActionEntity> getToutesLesInscriptions() {

            List<InscriptionActionEntity> mesInscriptions=null;
            try {

                mesInscriptions= inscriptionActionRepository.findAll();
            } catch (Exception e) {
                throw new MonException("Insert", "Sql", e.getMessage());
            }
            return mesInscriptions;
        }


    public InscriptionActionEntity getInscriptionID(int id) {
        return inscriptionActionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }

    public List<InscriptionActionEntity> getInscriptionsAByInscription(List<InscriptionEntity> list) {
        List<InscriptionActionEntity> listReturn = new ArrayList<>();
        for (InscriptionEntity i :
                list) {
            for (InscriptionActionEntity ia :
                    inscriptionActionRepository.findByIdInscription(i.getId())) {
                if(!listReturn.contains(ia)){
                    listReturn.add(ia);
                }
            }
        }
        return listReturn;
    }

    @Override
    public void ajouterInscription(InscriptionActionEntity inscription) {
        try {
            inscriptionActionRepository.save(inscription);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    @Override
    public void updateInscription(InscriptionActionEntity inscription){
        try{
            inscriptionActionRepository.save(inscription);
        } catch (Exception e) {
            throw new MonException("Update", "Sql", e.getMessage());
        }
    }

    public void supprimerInscription(InscriptionActionEntity inscription){
        try{
            inscriptionActionRepository.delete(inscription);
        } catch (Exception e) {
            throw new MonException("Delete", "Sql", e.getMessage());
        }
    }

}
