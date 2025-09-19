package com.Notes.demo.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersAccountDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String dob;
  
    
}
