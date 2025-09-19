package com.Notes.demo.Service;

import java.util.List;

import com.Notes.demo.DTOs.NotesDTO;
import com.Notes.demo.DTOs.NotesResponse;
import com.Notes.demo.Model.Note;
import com.Notes.demo.Model.UsersAccount;

public interface NoteService {
    
    NotesDTO createNote(NotesDTO notes, Long userId);
    NotesResponse getAllNotes(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    NotesDTO updateNotes(NotesDTO notes);
    NotesDTO deleteNotes(NotesDTO notes, Long notesId);
    List<Note> findUsersNotes(Long userId);



}
