package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Override
    public List<Movie> findAll();

    public Movie findById(int id);
}
