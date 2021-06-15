package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.InscriptionActionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IInscriptionActionService {


    public List<InscriptionActionEntity> getToutesLesInscriptions();

    public InscriptionActionEntity getInscriptionID(int id);

    public void ajouterInscription(InscriptionActionEntity unC);

    public void updateInscription(InscriptionActionEntity inscritpion);

}