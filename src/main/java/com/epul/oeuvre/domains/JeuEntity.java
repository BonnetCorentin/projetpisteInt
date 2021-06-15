package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "jeu", schema = "projetpermis", catalog = "")
public class JeuEntity {
    private int id;
    private int fkLearner;
    private int fkMission;
    private int scoreTotal;
    private Date date;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fk_learner")
    public int getFkLearner() {
        return fkLearner;
    }

    public void setFkLearner(int fkLearner) {
        this.fkLearner = fkLearner;
    }

    @Basic
    @Column(name = "fk_mission")
    public int getFkMission() {
        return fkMission;
    }

    public void setFkMission(int fkMission) {
        this.fkMission = fkMission;
    }

    @Basic
    @Column(name = "score_total")
    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;


    }
}
