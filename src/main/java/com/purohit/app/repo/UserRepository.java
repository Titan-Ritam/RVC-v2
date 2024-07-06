package com.purohit.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purohit.app.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByEmail(String email);
    
}
