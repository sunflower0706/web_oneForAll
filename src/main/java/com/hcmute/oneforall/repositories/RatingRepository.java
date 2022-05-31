package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.MovieGenre;
import com.hcmute.oneforall.beans.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
