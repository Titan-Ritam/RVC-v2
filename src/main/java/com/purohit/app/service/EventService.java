package com.purohit.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purohit.app.dto.EventDto;
import com.purohit.app.entity.Event;
import com.purohit.app.entity.User;
import com.purohit.app.repo.EventRepository;


@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


// ................. get event by user id .................. 

public List<Event> getAllEvents(User user){
    List<Event> event = eventRepository.findByUser(user);
    if (event.isEmpty()) {
        return null;
    }else{
        return event;
    }
}
// ......................createEvents................ 
public EventDto createEvent(EventDto eventDto, int id){
    User existUser = userService.getUser(id);
    if (existUser  != null){
        Event event = modelMapper.map(eventDto,Event.class);
        event.setUser(existUser);
        
        Event eventRes = eventRepository.save(event);
        EventDto eventDto2 = modelMapper.map(eventRes,EventDto.class);
        return eventDto2;
        }
        return null;
    }
// ....................... update event ......................
    public EventDto updateEvent(EventDto eventDto, int event_id,int user_id){
            User existUser = userService.getUser(user_id);
            Event exsistEvent = getEventById(event_id);
            int event_user_id = exsistEvent.getUser().getId();
            if (event_user_id == user_id) {
                Event event = modelMapper.map(eventDto,Event.class);
                event.setId(event_id);
                event.setUser(existUser);
                Event eventRes = eventRepository.save(event);
                EventDto eventDto2 = modelMapper.map(eventRes,EventDto.class);
                return eventDto2;
            }
            System.out.println("user id not matched");
            return null;
    }
    // event id er sathe user id o dite hobe noile update korle user id null jabe database a.
// ................. for get the all event .................
    public List<Event> getAllEvent(){
       List<Event> list = eventRepository.findAll();
       System.out.println(list);
       return list;
    }

    public List<Event> getEventByCity(String city){
        List<Event> eventRes = eventRepository.findByCity(city);
        return eventRes;
    }

    public Event getEventById(int id){
        Event resEvent = eventRepository.findById(id);
        if (resEvent != null){ 
            return resEvent;
        }
        return null;
    }
    

    
}
