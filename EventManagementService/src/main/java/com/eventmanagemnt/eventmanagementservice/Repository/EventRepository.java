package com.eventmanagemnt.eventmanagementservice.Repository;

import com.eventmanagemnt.eventmanagementservice.Model.Event;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByHostId(String hostId);
    List<Event> findByCategory(String category);
    List<Event> findByIdGreaterThanEqualOrderByIdAsc(String id, PageRequest pageable);
}
