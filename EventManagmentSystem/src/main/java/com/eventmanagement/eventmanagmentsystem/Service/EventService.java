package com.eventmanagement.eventmanagmentsystem.Service;

import com.eventmanagement.eventmanagmentsystem.Dto.EventRequest;
import com.eventmanagement.eventmanagmentsystem.Dto.EventResponse;
import com.eventmanagement.eventmanagmentsystem.Model.Event;
import com.eventmanagement.eventmanagmentsystem.Repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public EventResponse createEvent(EventRequest eventRequest, String coverImageUrl, String coverImageThumbnailUrl, List<String> imageUrls, List<String> imageThumbnails) {
        Event event = Event.builder()
                .hostId(eventRequest.hostId())
                .name(eventRequest.name())
                .description(eventRequest.description())
                .country(eventRequest.country())
                .city(eventRequest.city())
                .venue(eventRequest.venue())
                .location(eventRequest.location())
                .date(eventRequest.date())
                .category(eventRequest.category())
                .coverImage(coverImageUrl)
                .coverImageThumbnail(coverImageThumbnailUrl)
                .images(imageUrls)
                .imageThumbnails(imageThumbnails)
                .wishCount(eventRequest.wishCount())
                .build();

        eventRepository.save(event);
        return new EventResponse(
                event.getId(),
                event.getHostId(),
                event.getName(),
                event.getDescription(),
                event.getCountry(),
                event.getCity(),
                event.getVenue(),
                event.getLocation(),
                event.getDate(),
                event.getCategory(),
                event.getCoverImage(),
                event.getCoverImageThumbnail(),
                event.getImages(),
                event.getImageThumbnails(),
                event.getWishCount()
        );

    }

    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event -> new EventResponse(
                        event.getId(),
                        event.getHostId(),
                        event.getName(),
                        event.getDescription(),
                        event.getCountry(),
                        event.getCity(),
                        event.getVenue(),
                        event.getLocation(),
                        event.getDate(),
                        event.getCategory(),
                        event.getCoverImage(),
                        event.getCoverImageThumbnail(),
                        event.getImages(),
                        event.getImageThumbnails(),
                        event.getWishCount()
                )).toList();
    }

    public List<EventResponse> getEventById(String id) {
        return eventRepository.findById(id).stream()
                .map(event -> new EventResponse(
                        event.getId(),
                        event.getHostId(),
                        event.getName(),
                        event.getDescription(),
                        event.getCountry(),
                        event.getCity(),
                        event.getVenue(),
                        event.getLocation(),
                        event.getDate(),
                        event.getCategory(),
                        event.getCoverImage(),
                        event.getCoverImageThumbnail(),
                        event.getImages(),
                        event.getImageThumbnails(),
                        event.getWishCount()
                )).toList();
    }

    public List<EventResponse> getEventByHost(String id) {
        return eventRepository.findByHostId(id).stream()
                .map(event -> new EventResponse(
                        event.getId(),
                        event.getHostId(),
                        event.getName(),
                        event.getDescription(),
                        event.getCountry(),
                        event.getCity(),
                        event.getVenue(),
                        event.getLocation(),
                        event.getDate(),
                        event.getCategory(),
                        event.getCoverImage(),
                        event.getCoverImageThumbnail(),
                        event.getImages(),
                        event.getImageThumbnails(),
                        event.getWishCount()
                )).toList();
    }

    public List<EventResponse> getEventByCategory(String category) {
        return eventRepository.findByCategory(category).stream()
                .map(event -> new EventResponse(
                        event.getId(),
                        event.getHostId(),
                        event.getName(),
                        event.getDescription(),
                        event.getCountry(),
                        event.getCity(),
                        event.getVenue(),
                        event.getLocation(),
                        event.getDate(),
                        event.getCategory(),
                        event.getCoverImage(),
                        event.getCoverImageThumbnail(),
                        event.getImages(),
                        event.getImageThumbnails(),
                        event.getWishCount()
                )).toList();
    }

    public List<EventResponse> getTrendingEvents() {
        return eventRepository.findAll().stream()
                .sorted((event1, event2) -> event2.getWishCount() - event1.getWishCount())
                .limit(8)
                .map(event -> new EventResponse(
                        event.getId(),
                        event.getHostId(),
                        event.getName(),
                        event.getDescription(),
                        event.getCountry(),
                        event.getCity(),
                        event.getVenue(),
                        event.getLocation(),
                        event.getDate(),
                        event.getCategory(),
                        event.getCoverImage(),
                        event.getCoverImageThumbnail(),
                        event.getImages(),
                        event.getImageThumbnails(),
                        event.getWishCount()
                )).toList();
    }

    public List<EventResponse> getEvents(String id, String limit) {
        int limitNumber = Integer.parseInt(limit);
        PageRequest pageable = PageRequest.of(0, limitNumber);

        return eventRepository.findByIdGreaterThanEqualOrderByIdAsc(id, pageable).stream()
                .map(event -> new EventResponse(
                        event.getId(),
                        event.getHostId(),
                        event.getName(),
                        event.getDescription(),
                        event.getCountry(),
                        event.getCity(),
                        event.getVenue(),
                        event.getLocation(),
                        event.getDate(),
                        event.getCategory(),
                        event.getCoverImage(),
                        event.getCoverImageThumbnail(),
                        event.getImages(),
                        event.getImageThumbnails(),
                        event.getWishCount()
                )).toList();
    }
}
