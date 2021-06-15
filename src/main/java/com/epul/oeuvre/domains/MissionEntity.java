package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "mission", schema = "projetpermis", catalog = "")
public class MissionEntity {
    private int id;
    private String wording;
    private Collection<ActionMissionEntity> actionMissionsById;
    private Collection<InscriptionEntity> inscriptionsById;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wording")
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissionEntity that = (MissionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(wording, that.wording);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wording);
    }

    @OneToMany(mappedBy = "missionByFkMission")
    public Collection<ActionMissionEntity> getActionMissionsById() {
        return actionMissionsById;
    }

    public void setActionMissionsById(Collection<ActionMissionEntity> actionMissionsById) {
        this.actionMissionsById = actionMissionsById;
    }

    @OneToMany(mappedBy = "missionByFkMission")
    public Collection<InscriptionEntity> getInscriptionsById() {
        return inscriptionsById;
    }

    public void setInscriptionsById(Collection<InscriptionEntity> inscriptionsById) {
        this.inscriptionsById = inscriptionsById;
    }
}
