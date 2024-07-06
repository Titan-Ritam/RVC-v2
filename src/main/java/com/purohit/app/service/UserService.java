package com.purohit.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.purohit.app.dto.UserDto;
import com.purohit.app.entity.User;
import com.purohit.app.repo.UserRepository;

@Service
public class UserService {

  @Autowired
  private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser( UserDto userDto) {
    User user = modelMapper.map(userDto, User.class);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    User res = userRepository.save(user);
    return modelMapper.map(res, UserDto.class);
    }

    public User getUser(int id){
      Optional<User> opt = userRepository.findById(id);
      
      if (opt.isPresent()) {
      User res = opt.get();
      return res;
      }
      return null;
    }
    
    public void deleteUser(int id){
      userRepository.deleteById(id);
      
    }

    public List<User> getUsers(){
      List<User> list = userRepository.findAll();
      return list;
    }

    public User getUserByEmail(String email){
      User user = userRepository.findByEmail(email);
      return user; 
    }

    
    
}
