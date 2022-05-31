package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.MovieCast;
import com.hcmute.oneforall.beans.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCastRepository extends JpaRepository<MovieCast, Integer> {
}
