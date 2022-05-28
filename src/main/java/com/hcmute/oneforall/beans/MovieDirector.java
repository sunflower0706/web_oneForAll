package com.hcmute.oneforall.beans;

import com.hcmute.oneforall.key.MovieCastKey;
import com.hcmute.oneforall.key.MovieDirectorKey;

import javax.persistence.*;

@Entity
@Table(name = "movie_director")
public class MovieDirector {
    @EmbeddedId
    @Column(name = "idMD")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private MovieDirectorKey id;

    @ManyToOne
    @MapsId("idDT")
    @JoinColumn(name = "idDT")
    private Director director;

    @ManyToOne
    @MapsId("idMV")
    @JoinColumn(name = "idMV")
    private Movie movie;

    public void setId(MovieDirectorKey id) {
        this.id = id;
    }

    public MovieDirectorKey getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MovieDirector{" +
                "id=" + id +
                ", director=" + director +
                ", movie=" + movie +
                '}';
    }
}
