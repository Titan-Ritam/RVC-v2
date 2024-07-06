package com.purohit.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purohit.app.entity.PurohitEvent;
import com.purohit.app.entity.User;
import com.purohit.app.repo.PurohitEventRepository;
@Service
public class PurohitEventService {
    
    @Autowired
    private PurohitEventRepository purohitEventRepository;

    @Autowired
    private UserService userService;

    // @Autowired
    // private EventService eventService;

    public PurohitEvent createPurohitEvent(PurohitEvent event,int purohit_id){
        User user = userService.getUser(purohit_id);
        event.setUser(user);
        PurohitEvent res = this.purohitEventRepository.save(event);
        return res;
    }

    public List<PurohitEvent> getAllEvent() {
       List<PurohitEvent> purohitevents =this.purohitEventRepository.findAll();
        return purohitevents;
    }

    public PurohitEvent getPurohitEvent(int id) {
      Optional<PurohitEvent> purohitEvent =  this.purohitEventRepository.findById(id);
      if (purohitEvent.isPresent()) {
        PurohitEvent event = purohitEvent.get();
        return event;
      }else{
        return null;
      }
    }



    public String deletePurohitEvent(int purohit_id, int id) {
       PurohitEvent event = getPurohitEvent(id);
       User user = event.getUser();
       if (user.getId()==purohit_id) {
        this.purohitEventRepository.deleteById(id);
        return "Event is successfully deleted";
       }else{
        return "user dont have this event";
       }
    }

 
}
