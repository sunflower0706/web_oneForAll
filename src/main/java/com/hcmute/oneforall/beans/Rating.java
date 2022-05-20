package com.hcmute.oneforall.beans;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @Column(name = "idRT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "idTK")
    private int idTK;

    @Column(name = "idMV")
    private int idMV;

    @Column(name = "sao")
    private int sao;

    public Rating(){}

    public Rating(int id, int idTK, int idMV, int sao){
        this.id = id;
        this.idTK = idTK;
        this.idMV = idMV;
        this.sao = sao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getIdTK() {
        return idTK;
    }

    public int getIdMV() {
        return idMV;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }

    public int getSao() {
        return sao;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", idTK=" + idTK +
                ", idMV=" + idMV +
                ", sao=" + sao +
                '}';
    }
}
