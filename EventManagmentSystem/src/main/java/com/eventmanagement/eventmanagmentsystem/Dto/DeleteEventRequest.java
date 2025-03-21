package com.eventmanagement.eventmanagmentsystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class DeleteEventRequest {

    private String eventId;
    private String hostId;

}
