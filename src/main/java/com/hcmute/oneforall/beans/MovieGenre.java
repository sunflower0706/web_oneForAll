package com.hcmute.oneforall.beans;

import javax.persistence.*;

@Entity
@Table(name = "movie_genre")
public class MovieGenre {
    @Id
    @Column(name = "idMG")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "idGR")
    private int idGR;

    @Column(name = "idMV")
    private int idMV;

    public MovieGenre(){}

    public MovieGenre(int id, int idGR, int idMV){
        this.id = id;
        this.idGR = idGR;
        this.idMV = idMV;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getIdGR() {
        return idGR;
    }

    public int getIdMV() {
        return idMV;
    }

    @Override
    public String toString() {
        return "MovieGenre{" +
                "id=" + id +
                ", idGR=" + idGR +
                ", idMV=" + idMV +
                '}';
    }
}
