package com.Notes.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Notes.demo.DTOs.NotesResponse;
import com.Notes.demo.Model.Note;

public interface NotesRepository extends JpaRepository<Note, Long> {
    Note findByTitle(String title);
    List<Note> findNoteByUserId(Long userId);
   
}
