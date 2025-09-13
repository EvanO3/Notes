package com.Notes.demo.Service;

import com.Notes.demo.DTOs.NotesDTO;
import com.Notes.demo.DTOs.NotesResponse;

public interface NoteService {
    
    NotesDTO createNote(NotesDTO notes);
    NotesResponse getAllNotes(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    NotesDTO updateNotes(NotesDTO notes);
    NotesDTO deleteNotes(NotesDTO notes, Long notesId);

}
