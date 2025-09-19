package com.Notes.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Notes.demo.Config.AppConstants;
import com.Notes.demo.DTOs.NotesDTO;
import com.Notes.demo.DTOs.NotesResponse;
import com.Notes.demo.Model.Note;
import com.Notes.demo.Service.NoteService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class NoteContoller {
    
    @Autowired
    private NoteService noteService;

    @PostMapping("/public/notes/{userId}")
    public ResponseEntity<NotesDTO> createNote(@Valid @RequestBody NotesDTO note, @PathVariable Long userId){
        NotesDTO newNote = noteService.createNote(note, userId);
        return new ResponseEntity<>(newNote, HttpStatus.CREATED);


        
    }

    @GetMapping("/public/notes/{userId}")
    public ResponseEntity<List<Note>> getUserNotes(@PathVariable Long userId){
        List<Note> response = noteService.findUsersNotes(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/public/notes")
    public ResponseEntity<NotesResponse> getAllNotes (@RequestParam(defaultValue = AppConstants.PAGE_NUMBER) Integer pageNumber, 
    @RequestParam(defaultValue = AppConstants.PAGE_SIZE) Integer pageSize,
    @RequestParam(defaultValue = AppConstants.SORT_DIR) String sortOrder,
    @RequestParam(defaultValue = AppConstants.SORT_CATEGORY_BY) String sortBy) {
        NotesResponse response = noteService.getAllNotes(pageNumber, pageSize,sortBy, sortOrder);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    


}
