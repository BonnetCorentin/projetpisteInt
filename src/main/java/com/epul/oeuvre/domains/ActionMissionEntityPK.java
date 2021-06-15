package com.epul.oeuvre.domains;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ActionMissionEntityPK implements Serializable {
    private int fkAction;
    private int fkMission;

    @Column(name = "fk_action")
    @Id
    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    @Column(name = "fk_mission")
    @Id
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
        ActionMissionEntityPK that = (ActionMissionEntityPK) o;
        return fkAction == that.fkAction && fkMission == that.fkMission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkAction, fkMission);
    }
}
