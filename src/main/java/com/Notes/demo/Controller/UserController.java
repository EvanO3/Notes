package com.Notes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Notes.demo.DTOs.UsersAccountDTO;
import com.Notes.demo.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    
  @Autowired
    private UserService userService;


    @PostMapping("/public/create/user")
    public ResponseEntity<UsersAccountDTO> createUser(@RequestBody UsersAccountDTO userDTO){
        UsersAccountDTO savedUser = userService.createAccount(userDTO);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
        
    }
}
