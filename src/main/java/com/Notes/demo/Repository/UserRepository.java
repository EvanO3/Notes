package com.Notes.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Notes.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
