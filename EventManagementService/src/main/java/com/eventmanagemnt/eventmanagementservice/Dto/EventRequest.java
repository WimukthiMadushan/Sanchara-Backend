package com.eventmanagemnt.eventmanagementservice.Dto;

import org.springframework.web.multipart.MultipartFile;

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
) {
}
