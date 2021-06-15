package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "action", schema = "projetpermis", catalog = "")
public class ActionEntity {
    private int id;
    private Integer fkAction;
    private String wording;
    private Integer scoreMinimum;
    private ActionEntity actionByFkAction;
    private Collection<ActionEntity> actionsById;
    private Collection<ActionMissionEntity> actionMissionsById;
    private Collection<IndicatorEntity> indicatorsById;
    private Collection<InscriptionActionEntity> inscriptionActionsById;

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
    @Column(name = "fk_action")
    public Integer getFkAction() {
        return fkAction;
    }

    public void setFkAction(Integer fkAction) {
        this.fkAction = fkAction;
    }

    @Basic
    @Column(name = "wording")
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    @Basic
    @Column(name = "scoreMinimum")
    public Integer getScoreMinimum() {
        return this.scoreMinimum;
    }

    public void setScoreMinimum(Integer scoreMinimum) {
        this.scoreMinimum = scoreMinimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionEntity that = (ActionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(fkAction, that.fkAction) && Objects.equals(wording, that.wording) && Objects.equals(scoreMinimum, that.scoreMinimum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkAction, wording, scoreMinimum);
    }

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", insertable = false, updatable = false)
    public ActionEntity getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(ActionEntity actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }

    @OneToMany(mappedBy = "actionByFkAction")
    public Collection<ActionEntity> getActionsById() {
        return actionsById;
    }

    public void setActionsById(Collection<ActionEntity> actionsById) {
        this.actionsById = actionsById;
    }

    @OneToMany(mappedBy = "actionByFkAction")
    public Collection<ActionMissionEntity> getActionMissionsById() {
        return actionMissionsById;
    }

    public void setActionMissionsById(Collection<ActionMissionEntity> actionMissionsById) {
        this.actionMissionsById = actionMissionsById;
    }

    @OneToMany(mappedBy = "actionByFkAction")
    public Collection<IndicatorEntity> getIndicatorsById() {
        return indicatorsById;
    }

    public void setIndicatorsById(Collection<IndicatorEntity> indicatorsById) {
        this.indicatorsById = indicatorsById;
    }

    @OneToMany(mappedBy = "actionByFkAction")
    public Collection<InscriptionActionEntity> getInscriptionActionsById() {
        return inscriptionActionsById;
    }

    public void setInscriptionActionsById(Collection<InscriptionActionEntity> inscriptionActionsById) {
        this.inscriptionActionsById = inscriptionActionsById;
    }
}
