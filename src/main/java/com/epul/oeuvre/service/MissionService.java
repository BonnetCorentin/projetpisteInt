package com.epul.oeuvre.service;

import com.epul.oeuvre.domains.MissionEntity;
import com.epul.oeuvre.mesExceptions.MonException;
import com.epul.oeuvre.repositories.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService implements IMissionService {

    @Autowired
    private MissionRepository missionRepository;

    @Override
    public List<MissionEntity> getToutesLesMissions() {

            List<MissionEntity> mesMissions=null;
            try {

                mesMissions= missionRepository.findAll();
            } catch (Exception e) {
                throw new MonException("Insert", "Sql", e.getMessage());
            }
            return mesMissions;
        }


    public MissionEntity getMissionID(int id) {
        return missionRepository.findById(id).orElseThrow(
                () -> new MonException("Client", "id", id)
        );
    }
    
    @Override
    public void ajouterMission(MissionEntity mission) {
        try {
            missionRepository.save(mission);
        } catch (Exception e) {
            throw new MonException("Insert", "Sql", e.getMessage());
        }
    }

    @Override
    public void updateMission(MissionEntity mission){
        try{
            missionRepository.save(mission);
        } catch (Exception e) {
            throw new MonException("Update", "Sql", e.getMessage());
        }
    }

    public void supprimerMission(MissionEntity mission){
        try{
            missionRepository.delete(mission);
        } catch (Exception e) {
            throw new MonException("Delete", "Sql", e.getMessage());
        }
    }

}
