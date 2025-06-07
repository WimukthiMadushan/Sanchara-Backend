package com.usermanagement.reviewandratingservice.Repository;


import com.usermanagement.reviewandratingservice.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository  extends JpaRepository<Review, Long>{

    List<Review> findByEventID(int eventID);

    List<Review> findByUserID(int userID);
}
