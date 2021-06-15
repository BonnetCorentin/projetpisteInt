package com.epul.oeuvre.controller;

import com.epul.oeuvre.domains.LogiParam;
import com.epul.oeuvre.domains.LearnerEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.epul.oeuvre.utilitaires.MonMotPassHash;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/authentification")
@RestController
@CrossOrigin
public class ControllerLogin {
    // on initialise
    @Autowired
    private AuthentificationService unAuthenService;


    @RequestMapping("/login")
    public ModelAndView pageLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("views/formLogin");
    }

    @RequestMapping("/home")
    public ModelAndView pageIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("index");
    }

    @RequestMapping("/logOut")
    public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();

        String pageName = "index";

        return new ModelAndView(pageName);
    }

    ///
    //
    //// Contrôle Login
    ///
    ////
    @RequestMapping(method = RequestMethod.POST, value = "/getLogin")
    public ModelAndView controleLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        LogiParam unUtiParam = new LogiParam();
        HttpSession session;

        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        unUtiParam.setNomUtil(login);
        unUtiParam.setMotPasse(pwd);
        String message = "";
        try {
            LearnerEntity unLearner = unAuthenService.authentification(unUtiParam);
            if (unLearner != null) {
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
                    if (MonMotPassHash.verifyPassword(monpwdCo,mdp_byte)) {
                        session = request.getSession();
                        session.setAttribute("role", unLearner.getRole());
                        session.setAttribute("surname", unLearner.getSurname());
                        session.setAttribute("name", unLearner.getForname());
                        session.setAttribute("id", unLearner.getId());
                        destinationPage = "/index";
                    } else {
                        message = "mot de passe erroné";
                        request.setAttribute("message", message);
                        destinationPage = "/views/formLogin";
                    }
                } catch (Exception e) {
                request.setAttribute("MesErreurs", e.getMessage());
                destinationPage = "/views/Erreur";
                }
            } else {
                message = "login erroné";
                request.setAttribute("message", message);
                destinationPage = "/views/formLogin";
            }
        } catch (MonException e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/views/Erreur";
        }

        return new ModelAndView(destinationPage);
    }

}


