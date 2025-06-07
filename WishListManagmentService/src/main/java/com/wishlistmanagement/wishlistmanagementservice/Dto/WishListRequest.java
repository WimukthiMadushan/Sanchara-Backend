package com.wishlistmanagement.wishlistmanagementservice.Dto;

public record WishListRequest(
        String id,
        String eventId,
        String userId
) {
}
