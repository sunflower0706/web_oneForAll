package com.hcmute.oneforall.beans;

import javax.persistence.*;

@Entity
@Table(name = "movie_cast")
public class MovieCast {
    @Id
    @Column(name = "idMC")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "idAT")
    private int idAT;

    @Column(name = "idMV")
    private int idMV;

    @Column(name = "role")
    private String role;

    public MovieCast(){}

    public MovieCast(int id, int idAT, int idMV, String role){
        this.id = id;
        this.idAT = idAT;
        this.idMV = idMV;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getIdAT() {
        return idAT;
    }

    public int getIdMV() {
        return idMV;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "MovieCast{" +
                "id=" + id +
                ", idAT=" + idAT +
                ", idMV=" + idMV +
                ", role='" + role + '\'' +
                '}';
    }
}
