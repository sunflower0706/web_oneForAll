package com.hcmute.oneforall.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "idGR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mo_ta")
    private String mo_ta;

    @OneToMany(mappedBy = "genre")
    private Set<MovieGenre> movieGenres;

    public Genre(){}

    public Genre(int id, String mo_ta){
        this.id = id;
        this.mo_ta = mo_ta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", mo_ta='" + mo_ta + '\'' +
                '}';
    }
}
