package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "indicator", schema = "projetpermis", catalog = "")
public class IndicatorEntity {
    private Long id;
    private int fkAction;
    private String wording;
    private Integer valueIfCheck;
    private Integer valueIfUnCheck;
    private ActionEntity actionByFkAction;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Column(name = "wording")
    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    @Basic
    @Column(name = "valueIfCheck")
    public Integer getValueIfCheck() {
        return valueIfCheck;
    }

    public void setValueIfCheck(Integer valueIfCheck) {
        this.valueIfCheck = valueIfCheck;
    }

    @Basic
    @Column(name = "valueIfUnCheck")
    public Integer getValueIfUnCheck() {
        return valueIfUnCheck;
    }

    public void setValueIfUnCheck(Integer valueIfUnCheck) {
        this.valueIfUnCheck = valueIfUnCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndicatorEntity that = (IndicatorEntity) o;
        return fkAction == that.fkAction && Objects.equals(id, that.id) && Objects.equals(wording, that.wording) && Objects.equals(valueIfCheck, that.valueIfCheck) && Objects.equals(valueIfUnCheck, that.valueIfUnCheck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkAction, wording, valueIfCheck, valueIfUnCheck);
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
