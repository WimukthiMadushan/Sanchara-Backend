package com.emailservice.emailservice.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEvent {
    private String eventName;
    private String eventDate;
    private String eventLocation;
    private String email;
}
