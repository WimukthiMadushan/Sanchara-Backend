package com.eventmanagement.eventmanagmentsystem.Controller;

import com.eventmanagement.eventmanagmentsystem.Dto.EventRequest;
import com.eventmanagement.eventmanagmentsystem.Dto.EventResponse;
import com.eventmanagement.eventmanagmentsystem.Service.CloudinaryService;
import com.eventmanagement.eventmanagmentsystem.Service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse createEvent(@ModelAttribute EventRequest eventRequest) throws IOException {
        String coverImageUrl = cloudinaryService.uploadImage(eventRequest.coverImage());
        String coverImageThumbnailUrl = cloudinaryService.uploadThumbnail(eventRequest.coverImage());

        List<String> imageUrls = new ArrayList<>();
        List<String> imageThumbnails = new ArrayList<>();

        if (eventRequest.images() != null) {
            for (MultipartFile image : eventRequest.images()) {
                imageUrls.add(cloudinaryService.uploadImage(image));
                imageThumbnails.add(cloudinaryService.uploadThumbnail(image));
            }
        }
        return eventService.createEvent(eventRequest,coverImageUrl,coverImageThumbnailUrl,imageUrls,imageThumbnails);
    }

    @GetMapping("/getAll")
    public List<EventResponse> getAllEvent(){
        return eventService.getAllEvents();
    }
    @GetMapping("/getEvents")
    public List<EventResponse> getEvents(@RequestParam Map<String,String> request){
        String id = request.get("id");
        String limit = request.get("limit");
        return eventService.getEvents(id,limit);
    }
    @GetMapping("/get/{id}")
    public List<EventResponse> getEventById(@PathVariable String id){
        return eventService.getEventById(id);
    }
    @PostMapping("/getEventByHost")
    public List<EventResponse> getEventByHost(@RequestBody Map<String,String> request){
        String id = request.get("host_id");
        return eventService.getEventByHost(id);
    }
    @GetMapping("/getEventByCategory")
    public List<EventResponse> getEventByCategory(@RequestParam Map<String,String> request){
        String category = request.get("category");
        return eventService.getEventByCategory(category);
    }
    @GetMapping("/getTrendingEvents")
    public List<EventResponse> getTrendingEvents(){
        return eventService.getTrendingEvents();
    }

}
