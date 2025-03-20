package com.eventmanagement.eventmanagmentsystem.Dto;

import java.time.LocalDateTime;
import java.util.List;

public record EventResponse (
        String id,
        String hostId,
        String name,
        String description,
        String country,
        String city,
        String venue,
        String location,
        LocalDateTime date,
        String category,
        String coverImage,
        String coverImageThumbnail,
        List<String> images,
        List<String> imageThumbnails,
        Integer wishCount
) { }
