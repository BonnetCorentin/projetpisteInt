package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.LogiParam;
import com.epul.oeuvre.domains.LearnerEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.LearnerRepository;
import com.epul.oeuvre.utilitaires.MonMotPassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements IAuthentificationService {

    private LearnerRepository unLearnerRepostory;

    @Autowired
    public AuthentificationService(LearnerRepository LearnerRepostory) {
        this.unLearnerRepostory = LearnerRepostory;
    }

    @Override
    public LearnerEntity authentification(LogiParam unUti) throws Exception {
        LearnerEntity unLearner = null;
        String message;
        String login = unUti.getNomUtil();
        String pwd = unUti.getMotPasse();
        unLearner = unLearnerRepostory.rechercheNom(unUti.getNomUtil());
        if (unLearner == null) {
           return null;
        }
        /*if (unLearner != null) {
            try {
                // on récupère le sel
                String sel = unLearner.getSalt();
                // on récupère le mot de passe
                String mdp = unLearner.getMdp();
                // on génère le mot de passe avec les données de connexion
                byte[] salt = MonMotPassHash.transformeEnBytes(unLearner.getSalt());
                char[] pwd_char = MonMotPassHash.converttoCharArray(pwd);
                byte[] monpwdCo = MonMotPassHash.generatePasswordHash(pwd_char, salt);
                // on récupère le mot de passe enregistré
                byte[] mdp_byte = MonMotPassHash.transformeEnBytes(mdp);
                if (!(unLearner.getMdp().equals(unUti.getMotPasse()))) {
                    message = "Le mot de passe est erroné";
                    return null;
                }
            } catch (MonException e) {
                throw e;
            } catch (Exception e) {
                throw e;
            }
        }*/
        return unLearner;
    }
}
