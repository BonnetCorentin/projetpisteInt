package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.MissionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface IMissionService {


    public List<MissionEntity> getToutesLesMissions();

    public MissionEntity getMissionID(int id);

    public void ajouterMission(MissionEntity unC);

    public void updateMission(MissionEntity action);

}