package com.eventmanagement.eventmanagmentsystem.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(value = "Event")
@AllArgsConstructor
@NoArgsConstructor
@Builder //Enables the Builder pattern.
@Data
public class Event {
    @Id
    private String id;
    private String hostId;
    private String name;
    private String description;
    private String country;
    private String city;
    private String venue;
    private String location;
    private LocalDateTime date;
    private String category;
    private String coverImage;
    private String coverImageThumbnail;
    private List<String> images;
    private List<String> imageThumbnails;
    private Integer wishCount;

}
