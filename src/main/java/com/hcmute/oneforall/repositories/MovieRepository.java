package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Movie;
import com.hcmute.oneforall.beans.MovieCast;
import com.hcmute.oneforall.beans.Rating;
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
}
