package com.hcmute.oneforall.beans;

import com.hcmute.oneforall.key.MovieDirectorKey;

import javax.persistence.*;

@Entity
@Table(name = "movie_director")
public class MovieDirector {
    @EmbeddedId
    @Column(name = "idMD")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setDirector(Director director) {
        this.director = director;
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
