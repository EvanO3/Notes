package com.Notes.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Notes.demo.Model.Note;

public interface NotesRepository extends JpaRepository<Note, Long> {
    Note findByTitle(String title);
}
