package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.LogiParam;
import com.epul.oeuvre.domains.LearnerEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface IAuthentificationService {

    public LearnerEntity authentification(@RequestBody LogiParam unUti) throws Exception;

}
