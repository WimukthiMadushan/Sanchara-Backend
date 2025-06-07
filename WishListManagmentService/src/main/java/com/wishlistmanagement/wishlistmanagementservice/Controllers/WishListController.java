package com.wishlistmanagement.wishlistmanagementservice.Controllers;

import com.wishlistmanagement.wishlistmanagementservice.Dto.WishListRequest;
import com.wishlistmanagement.wishlistmanagementservice.Dto.WishListResponse;
import com.wishlistmanagement.wishlistmanagementservice.Service.WishListService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/wishlist")
@RequiredArgsConstructor
public class WishListController {

    private final WishListService wishListService;

    @PostMapping("/addToWishList")
    public WishListResponse addWishList(@RequestBody WishListRequest wishListRequest) {
        return wishListService.addWishList(wishListRequest);

    }
    @DeleteMapping("/removeFromWishList")
    public WishListResponse removeWishList(@RequestBody WishListRequest wishListRequest) {
        return wishListService.removeWishList(wishListRequest);
    }
    @GetMapping("/getWishList/{userId}")
    public List<WishListResponse> getWishList(@PathVariable String userId) {
        return wishListService.getWishListByUserId(userId);
    }
    @GetMapping("/getWishList/{userId}/{eventId}")
    public WishListResponse getWishListByEventId(@PathVariable String userId, @PathVariable String eventId) {
        return wishListService.getWishListByEventAndUserId(userId, eventId);
    }
    @GetMapping("/getWishList/{eventId}")
    public List<WishListResponse> getWishListByEventId(@PathVariable String eventId) {
        return wishListService.getWishListByEventId(eventId);
    }

}
