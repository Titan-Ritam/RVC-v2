package com.purohit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purohit.app.dto.UserDto;
import com.purohit.app.entity.User;
import com.purohit.app.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    // ............Save USer................... 
    @PostMapping("/save")
    public ResponseEntity<UserDto> SaveUSer(@Valid @RequestBody UserDto userDto) {
        if (userDto == null) {
            return ResponseEntity.badRequest().build();
        }
        else{
            UserDto res = userService.saveUser(userDto);
            return ResponseEntity.ok().body(res);
    }
}

// .................Get one perticuller User................... 
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        System.out.println(id);
        User res = userService.getUser(id);
        
        if (res == null) {
            log.info("it is not indatabase");
            return ResponseEntity.notFound().build();
            }
            else{
                log.info("user is {}",res.getName());
                return ResponseEntity.ok().body(res);
            }
        
    }
// ..............................update user with user id...............................
    @PostMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("id") int id) {
        userDto.setId(id);
        UserDto res = userService.saveUser(userDto);
        return ResponseEntity.ok().body(res);
    }
// ......................remove user.........................
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeUser(@PathVariable int id){
        User avail = userService.getUser(id);
        if (avail == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Available");
        }
    else{
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User Deleted successfully");
        }
    }
// ..................... get list of user.........................
    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUser(){
       List<User> res = userService.getUsers();
       return ResponseEntity.ok().body(res);
    }

   

}