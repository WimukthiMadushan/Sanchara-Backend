package com.wishlistmanagement.wishlistmanagementservice.Service;

import com.wishlistmanagement.wishlistmanagementservice.Dto.WishListRequest;
import com.wishlistmanagement.wishlistmanagementservice.Dto.WishListResponse;
import com.wishlistmanagement.wishlistmanagementservice.Model.FavouriteEvent;
import com.wishlistmanagement.wishlistmanagementservice.Repository.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {
    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public WishListResponse addWishList(WishListRequest wishListRequest) {
        FavouriteEvent favouriteEvent = FavouriteEvent.builder()
                .eventId(wishListRequest.eventId())
                .userId(wishListRequest.userId())
                .build();

        FavouriteEvent savedEvent = wishListRepository.save(favouriteEvent);
        return new WishListResponse(
                savedEvent.getId(),
                savedEvent.getEventId(),
                savedEvent.getUserId()
        );
    }


    public List<WishListResponse> getWishListByUserId(String userId) {
        List<FavouriteEvent> favouriteEvents = wishListRepository.findByUserId(userId);
        return favouriteEvents.stream()
                .map(event -> new WishListResponse(
                        event.getId(),
                        event.getEventId(),
                        event.getUserId()
                ))
                .toList();
    }

    public WishListResponse getWishListByEventAndUserId(String userId, String eventId) {
        List<FavouriteEvent> favouriteEvents = wishListRepository.findByUserId(userId);
        for (FavouriteEvent event : favouriteEvents) {
            if (event.getEventId().equals(eventId)) {
                return new WishListResponse(
                        event.getId(),
                        event.getEventId(),
                        event.getUserId()
                );
            }
        }
        return null;
    }

    public List<WishListResponse> getWishListByEventId(String eventId) {
        List<FavouriteEvent> favouriteEvents = wishListRepository.findByEventId(eventId);
        return favouriteEvents.stream()
                .map(event -> new WishListResponse(
                        event.getId(),
                        event.getEventId(),
                        event.getUserId()
                ))
                .toList();
    }

    public WishListResponse removeWishList(WishListRequest wishListRequest) {
        List<FavouriteEvent> favouriteEvents = wishListRepository.findByUserId(wishListRequest.userId());
        for (FavouriteEvent event : favouriteEvents) {
            if (event.getEventId().equals(wishListRequest.eventId())) {
                wishListRepository.delete(event);
                return new WishListResponse(
                        event.getId(),
                        event.getEventId(),
                        event.getUserId()
                );
            }
        }
        return null;
    }
}
