package com.purohit.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purohit.app.entity.Event;
import com.purohit.app.entity.User;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
    
    public List<Event> findByUser(User user);

    public List<Event> findByCity(String city);

    public Event findById(int id);
}
