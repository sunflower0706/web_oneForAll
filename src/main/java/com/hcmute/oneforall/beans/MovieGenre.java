package com.hcmute.oneforall.beans;

import com.hcmute.oneforall.key.MovieGenreKey;

import javax.persistence.*;

@Entity
@Table(name = "movie_genre")
public class MovieGenre {
    @EmbeddedId
    @Column(name = "idMG")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private MovieGenreKey id;

    @ManyToOne
    @MapsId("idGR")
    @JoinColumn(name = "idGR")
    private Genre genre;

    @ManyToOne
    @MapsId("idMV")
    @JoinColumn(name = "idMV")
    private Movie movie;


    public void setId(MovieGenreKey id) {
        this.id = id;
    }

    public MovieGenreKey getId() {
        return id;
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
