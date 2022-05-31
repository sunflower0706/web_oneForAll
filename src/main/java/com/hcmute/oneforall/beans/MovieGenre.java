package com.hcmute.oneforall.beans;

import com.hcmute.oneforall.key.MovieGenreKey;

import javax.persistence.*;

@Entity
@Table(name = "movie_genre")
public class MovieGenre {
    @EmbeddedId
    @Column(name = "idMG")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private MovieGenreKey id;

    @ManyToOne
    @MapsId("idGR")
    @JoinColumn(name = "idGR")
    private Genre genre;

    @ManyToOne
    @MapsId("idMV")
    @JoinColumn(name = "idMV")
    private Movie movie;

    public MovieGenre(){}

    public void setId(MovieGenreKey id) {
        this.id = id;
    }

    public MovieGenreKey getId() {
        return id;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "MovieGenre{" +
                "id=" + id +
                ", genre=" + genre +
                ", movie=" + movie +
                '}';
    }
}
