package com.purohit.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.purohit.app.entity.PurohitEvent;

public interface PurohitEventRepository extends JpaRepository<PurohitEvent,Integer> {
    
}
