package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "inscription__action", schema = "projetpermis", catalog = "")
public class InscriptionActionEntity {
    private int id;
    private int fkInscription;
    private int fkAction;
    private Integer sort;
    private Integer score;
    private InscriptionEntity inscriptionByFkInscription;
    private ActionEntity actionByFkAction;

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
    @Column(name = "fk_inscription")
    public int getFkInscription() {
        return fkInscription;
    }

    public void setFkInscription(int fkInscription) {
        this.fkInscription = fkInscription;
    }

    @Basic
    @Column(name = "fk_action")
    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionActionEntity that = (InscriptionActionEntity) o;
        return fkInscription == that.fkInscription && fkAction == that.fkAction && Objects.equals(id, that.id) && Objects.equals(sort, that.sort) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkInscription, fkAction, sort, score);
    }

    @ManyToOne
    @JoinColumn(name = "fk_inscription", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public InscriptionEntity getInscriptionByFkInscription() {
        return inscriptionByFkInscription;
    }

    public void setInscriptionByFkInscription(InscriptionEntity inscriptionByFkInscription) {
        this.inscriptionByFkInscription = inscriptionByFkInscription;
    }

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ActionEntity getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(ActionEntity actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }
}
