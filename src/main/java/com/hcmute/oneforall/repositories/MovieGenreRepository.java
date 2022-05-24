package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieGenreRepository extends JpaRepository<MovieGenre, Integer> {
}
