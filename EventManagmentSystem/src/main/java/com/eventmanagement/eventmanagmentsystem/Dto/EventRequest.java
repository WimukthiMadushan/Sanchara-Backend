package com.eventmanagement.eventmanagmentsystem.Dto;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public record EventRequest(
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
        MultipartFile coverImage,
        List<MultipartFile> images,
        Integer wishCount
) { }
