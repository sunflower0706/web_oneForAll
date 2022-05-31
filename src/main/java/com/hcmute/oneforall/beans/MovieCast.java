package com.hcmute.oneforall.beans;

import com.hcmute.oneforall.key.MovieCastKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie_cast")
public class MovieCast implements Serializable {
    @EmbeddedId
    @Column(name = "idMC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private MovieCastKey id;

    @ManyToOne
    @MapsId("idMV")
    @JoinColumn(name = "idMV")
    private Movie movie;

    @ManyToOne
    @MapsId("idAT")
    @JoinColumn(name = "idAT")
    private Actor   actor;

    @Column(name = "role")
    private String role;

    public void setId(MovieCastKey id) {
        this.id = id;
    }

    public MovieCastKey getId() {
        return id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
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
                ", movie=" + movie +
                ", actor=" + actor +
                ", role='" + role + '\'' +
                '}';
    }
}
