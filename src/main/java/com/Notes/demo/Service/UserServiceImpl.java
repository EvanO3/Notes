package com.Notes.demo.Service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Notes.demo.DTOs.UsersAccountDTO;
import com.Notes.demo.Model.UsersAccount;

import com.Notes.demo.Repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UsersAccountDTO createAccount(UsersAccountDTO userDto){
    UsersAccount user = modelMapper.map(userDto, UsersAccount.class);
    userRepository.save(user);
    return modelMapper.map(user, UsersAccountDTO.class);
}
    
   
  
}
