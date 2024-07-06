package com.purohit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purohit.app.entity.Event;
import com.purohit.app.entity.PurohitEvent;
import com.purohit.app.service.EventService;
import com.purohit.app.service.PurohitEventService;


@RestController
@RequestMapping("/purohit")
@CrossOrigin(origins = "http://localhost:3000")
public class PurohitController {

    @Autowired
    private EventService eventService;

    @Autowired
    private PurohitEventService purohitEventService;

    // .................... for get all events to book one event................ 
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvent(){
        System.out.println("in method");
        List<Event> events = eventService.getAllEvent();
        System.out.println(events);
        return ResponseEntity.ok().body(events);
    }
    // ....................... get all events by city .....................  
    @GetMapping("/events/{city}")
    public ResponseEntity<List<Event>> getEventByCity(@PathVariable("city") String city){
        List<Event> res = eventService.getEventByCity(city);
        return ResponseEntity.ok().body(res);
    }
        // .................... create event by purohit................. 
    @PostMapping("/{purohit_id}")
    public ResponseEntity<PurohitEvent> createPurohitEvent(@RequestBody PurohitEvent event , @PathVariable("purohit_id") int purohit){
        System.out.println("okkk");
        PurohitEvent purohitEvent = this.purohitEventService.createPurohitEvent(event, purohit);
        System.out.println("okkk");
        return ResponseEntity.ok().body(purohitEvent);
    }
    //...........................get all events from purohit_event to hide it from other purohit because its assgined to one purohit already................

    @GetMapping("/purohitevent")
    public ResponseEntity<List<PurohitEvent>> getEventfromPurohitEvent() {
        List<PurohitEvent> events = this.purohitEventService.getAllEvent();
        return ResponseEntity.ok().body(events);
        }
     
    
    // delete purohit event  with help of event id and purohit id
    @DeleteMapping("/{purohit_id}/{id}/event")
    public ResponseEntity<String> deletePurohitevent(@PathVariable("id") int id , @PathVariable("purohit_id") int purohit_id){
        System.out.println("hiiii");
        this.purohitEventService.deletePurohitEvent(purohit_id,id);
        return ResponseEntity.ok().body("deleted");
    }


}
