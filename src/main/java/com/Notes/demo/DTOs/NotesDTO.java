package com.Notes.demo.DTOs;



import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotesDTO {
    private Long Id;
    private String title;
    private String content;
    private LocalDate createdAt;
}
