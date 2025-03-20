package com.eventmanagement.eventmanagmentsystem.Repository;

import com.eventmanagement.eventmanagmentsystem.Model.Event;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByHostId(String hostId);
    List<Event> findByCategory(String category);
    List<Event> findByIdGreaterThanEqualOrderByIdAsc(String id, PageRequest pageable);
}
