package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "action__mission", schema = "projetpermis", catalog = "")
@IdClass(ActionMissionEntityPK.class)
public class ActionMissionEntity {
    private int fkAction;
    private int fkMission;
    private ActionEntity actionByFkAction;
    private MissionEntity missionByFkMission;
    @Id
    @Column(name = "fk_action")
    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    @Id
    @Column(name = "fk_mission")
    public int getFkMission() {
        return fkMission;
    }

    public void setFkMission(int fkMission) {
        this.fkMission = fkMission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionMissionEntity that = (ActionMissionEntity) o;
        return fkAction == that.fkAction && fkMission == that.fkMission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkAction, fkMission);
    }

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ActionEntity getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(ActionEntity actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }

    @ManyToOne
    @JoinColumn(name = "fk_mission", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public MissionEntity getMissionByFkMission() {
        return missionByFkMission;
    }

    public void setMissionByFkMission(MissionEntity missionByFkMission) {
        this.missionByFkMission = missionByFkMission;
    }
}
