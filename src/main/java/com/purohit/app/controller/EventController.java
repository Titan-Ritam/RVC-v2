package com.purohit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purohit.app.dto.EventDto;
import com.purohit.app.entity.Event;
import com.purohit.app.entity.User;
import com.purohit.app.service.EventService;
import com.purohit.app.service.UserService;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public ResponseEntity<List<Event>> getEvent(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        List<Event> eventRes = eventService.getAllEvents(user);
        return ResponseEntity.ok().body(eventRes);
    }

    // ......................Create Event ................

    @PostMapping("/{user_id}")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto,@PathVariable("user_id") int user_id){
        EventDto eventDtoRes = eventService.createEvent(eventDto,user_id);
        if (eventDtoRes == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(eventDtoRes);
        }
    }
// ....................Update Events.................

@PutMapping("/{event_id},{user_id}")
    public ResponseEntity<EventDto> updateEvent(@RequestBody EventDto eventDto,@PathVariable("event_id") int event_id ,@PathVariable("user_id") int user_id){
        EventDto eventDtoRes = eventService.updateEvent(eventDto,event_id,user_id);
        if (eventDtoRes == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(eventDtoRes);
        }
    }




}
