package com.hcmute.oneforall.beans;

import javax.persistence.*;

@Entity
@Table(name = "movie_director")
public class MovieDirector {
    @Id
    @Column(name = "idMD")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "idDT")
    private int idDT;

    @Column(name = "idMV")
    private int idMV;

    public MovieDirector(){}

    public MovieDirector(int id, int idDT, int idMV){
        this.id = id;
        this.idDT = idDT;
        this.idMV = idMV;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMV() {
        return idMV;
    }

    public int getIdDT() {
        return idDT;
    }

    @Override
    public String toString() {
        return "MovieDirector{" +
                "id=" + id +
                ", idDT=" + idDT +
                ", idMV=" + idMV +
                '}';
    }
}
