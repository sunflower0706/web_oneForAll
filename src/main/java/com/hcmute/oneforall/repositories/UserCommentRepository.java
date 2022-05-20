package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentRepository extends JpaRepository<Rating, Integer> {

}
