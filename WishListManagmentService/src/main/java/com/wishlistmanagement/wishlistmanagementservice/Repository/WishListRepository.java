package com.wishlistmanagement.wishlistmanagementservice.Repository;

import com.wishlistmanagement.wishlistmanagementservice.Model.FavouriteEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends MongoRepository<FavouriteEvent, String> {
    List<FavouriteEvent> findByUserId(String userId);
    List<FavouriteEvent> findByEventId(String eventId);
    // Additional query methods can be defined here if needed

}
