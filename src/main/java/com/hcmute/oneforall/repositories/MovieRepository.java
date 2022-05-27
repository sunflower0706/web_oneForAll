package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Override
    public ArrayList<Movie> findAll();

    public Movie findById(int id);
}
