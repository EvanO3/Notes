package com.Notes.demo.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersAccount {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    private Long id;
    
    private String firstName;
    private String lastName;
    private String dob;

    @OneToMany(mappedBy = "user")
    private List<Note> notes = new ArrayList<>();
    
    
}
