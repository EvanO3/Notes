package com.Notes.demo.Service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.Notes.demo.DTOs.NotesDTO;
import com.Notes.demo.DTOs.NotesResponse;
import com.Notes.demo.Exceptions.APIExceptions;
import com.Notes.demo.Exceptions.ResourceNotFound;
import com.Notes.demo.Model.Note;
import com.Notes.demo.Repository.NotesRepository;

@Service
public class NoteServiceImp implements NoteService {

    @Autowired
    private NotesRepository repository;
    
    @Autowired
    private ModelMapper modelMapper;



    public NotesDTO createNote(NotesDTO notes){
        /*Map the incoming DTO to a the Notes class so its in the format we need to search the DB */
     Note mappedNote = modelMapper.map(notes, Note.class);
     System.out.println("Got here, this is mapped note: "+ mappedNote);
     /*check the db to see if any notes with the same title are already there */
     Note savedNote = repository.findByTitle(notes.getTitle());

     /*if the check comes back null, then there are no notes with the same name */
    if(savedNote !=null){
        throw new APIExceptions("Note with title: " + savedNote.getTitle() + " already exists");
    }
    /*save the new note */
    repository.save(mappedNote);
    NotesDTO newNote = modelMapper.map(mappedNote, NotesDTO.class);

    return newNote;

    
        
    }



    @Override
    public NotesResponse getAllNotes(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        /*Look at the sort order given, if its equal to asc then sortBy ascending order else sort by descending */
       Sort sortAndOrderBy = sortOrder.equalsIgnoreCase("asc") 
       ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        PageRequest pageDetails = PageRequest.of(pageNumber, pageSize, sortAndOrderBy);

        Page<Note> pageOfNotes = repository.findAll(pageDetails);
        List<Note> notes = pageOfNotes.getContent();
        if(notes.isEmpty()){
            throw new ResourceNotFound("There are no resources found");
        }

        List<NotesDTO> notesDTO = notes.stream().map(note-> modelMapper.map(note, NotesDTO.class))
        .toList();
        NotesResponse response = new NotesResponse();
        
        
        response.setContent(notesDTO);
        response.setPageNumber(pageOfNotes.getNumber());
        response.setPageSize(pageOfNotes.getSize());
        response.setLastPage(pageOfNotes.isLast());
        response.setTotalElements(pageOfNotes.getTotalElements());
        response.setTotalPages(pageOfNotes.getTotalPages());
        return response;
     

       
    }




    @Override
    public NotesDTO updateNotes(NotesDTO notes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateNotes'");
    }



    @Override
    public NotesDTO deleteNotes(NotesDTO notes, Long notesId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteNotes'");
    }
    

    
}
