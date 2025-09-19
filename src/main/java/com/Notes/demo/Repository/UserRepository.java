package com.Notes.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Notes.demo.Model.UsersAccount;

public interface UserRepository extends JpaRepository<UsersAccount, Long> {

    
}
