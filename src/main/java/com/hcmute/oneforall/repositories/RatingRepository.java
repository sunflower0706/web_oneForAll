package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    public ArrayList<Rating> findAllByIdMV(int id);
}
