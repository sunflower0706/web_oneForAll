package com.hcmute.oneforall.beans;

import javax.persistence.*;

@Entity
@Table(name = "usercomment")
public class UserComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUC;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTK;

//    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMV;

    @Column(name = "comment")
    private String comment;

    public UserComment(){}
    public UserComment(int idUC, int idTK, int idMV, String comment){
        this.idUC = idUC;
        this.idTK = idTK;
        this.idMV = idMV;
        this.comment = comment;
    }

    public void setIdUC(int idUC) {
        this.idUC = idUC;
    }

    public int getIdUC() {
        return idUC;
    }

    public void setIdTK(int idTK) {
        this.idTK = idTK;
    }

    public int getIdTK() {
        return idTK;
    }

    public void setIdMV(int idMV) {
        this.idMV = idMV;
    }

    public int getIdMV() {
        return idMV;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "UserComment{" +
                "idUC=" + idUC +
                ", idTK=" + idTK +
                ", idMV=" + idMV +
                ", comment='" + comment + '\'' +
                '}';
    }
}
