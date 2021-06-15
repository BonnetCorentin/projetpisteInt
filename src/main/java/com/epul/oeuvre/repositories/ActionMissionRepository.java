package com.epul.oeuvre.repositories;


import com.epul.oeuvre.domains.ActionMissionEntity;
import com.epul.oeuvre.domains.ActionMissionEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionMissionRepository extends JpaRepository<ActionMissionEntity, Integer> {

    @Query("SELECT i FROM ActionMissionEntity i where i.fkAction = :idAction")
    public List<ActionMissionEntity> findByIdAction(@Param("idAction")int idAction);

    @Query("SELECT i FROM ActionMissionEntity i where i.fkAction = :idAction and i.fkMission = :idMission")
    public ActionMissionEntity findByIdActionMission(@Param("idAction")int idAction, @Param("idMission")int idMission);

    @Query("SELECT i FROM ActionMissionEntity i WHERE NOT EXISTS (SELECT i FROM ActionMissionEntity i where i.fkAction = :id)")
    public List<ActionMissionEntity> findActionsSansMissionId(@Param("id")int id);

    @Query("SELECT i FROM ActionMissionEntity i where i.fkMission = :idMission")
    public List<ActionMissionEntity> findByIdMission(@Param("idMission")int idMission);
}
