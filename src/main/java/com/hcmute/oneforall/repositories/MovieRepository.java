package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.*;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Override
    public ArrayList<Movie> findAll();

    public Movie findById(int id);

    @Query(value = "SELECT r.movie.id, " +
            "r.movie.ten_phim, " +
            "r.movie.chat_luong, " +
            "r.movie.thoi_luong, " +
            "r.movie.mo_ta, " +
            "r.movie.link_phim, " +
            "COALESCE(AVG(r.sao), 0) as sao " +
            "FROM Rating r GROUP BY r.movie.id")
    public ArrayList<Object[]> findAllMovieWithRating();

    @Query(value = "SELECT mg.movie.id ,mg.movie.ten_phim, mg.genre.mo_ta FROM MovieGenre mg")
    public ArrayList<Object[]> findAllMovieWithGenre();

    @Query(value = "SELECT mg.genre.mo_ta FROM MovieGenre mg WHERE mg.movie.id = ?1")
    public ArrayList<String> findGenres(int id);

    @Query(value = "SELECT CONCAT(mc.actor.ho, ' ',  mc.actor.ten) FROM MovieCast mc WHERE mc.movie.id = ?1")
    public ArrayList<String> findActors(int id);

    @Query(value = "SELECT CONCAT(md.director.ho, ' ', md.director.ten) FROM MovieDirector md WHERE md.movie.id = ?1")
    public ArrayList<String> findDirector(int id);
}
