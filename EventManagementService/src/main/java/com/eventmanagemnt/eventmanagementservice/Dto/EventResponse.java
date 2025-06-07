package com.eventmanagemnt.eventmanagementservice.Dto;

import java.util.List;

public record EventResponse(
        String id,
        String hostId,
        String name,
        String description,
        String country,
        String city,
        String venue,
        String location,
        String date,
        String category,
        String coverImage,
        String coverImageThumbnail,
        List<String> images,
        List<String> imageThumbnails,
        Integer wishCount
) {
}
