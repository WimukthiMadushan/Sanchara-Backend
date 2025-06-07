package com.wishlistmanagement.wishlistmanagementservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "favouriteEvent")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FavouriteEvent {
    @Id
    private String id;
    private String eventId;
    private String userId;
}
