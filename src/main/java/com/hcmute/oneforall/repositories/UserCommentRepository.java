package com.hcmute.oneforall.repositories;

import com.hcmute.oneforall.beans.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentRepository extends JpaRepository<UserComment, Integer> {

}
