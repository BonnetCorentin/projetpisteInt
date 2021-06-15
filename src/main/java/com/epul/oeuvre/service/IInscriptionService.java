package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.InscriptionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IInscriptionService {


    public List<InscriptionEntity> getToutesLesInscriptions();

    public InscriptionEntity getInscriptionID(int id);

    public void ajouterInscription(InscriptionEntity unC);

    public void updateInscription(InscriptionEntity inscritpion);

}