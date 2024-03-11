package com.notedata.service;

import com.notedata.entity.Note;
import com.notedata.exception.NoteNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteService {
    Note add(Note note);

    List<Note> listAll();

    Note getById(UUID id) throws NoteNotFoundException;

    void deleteById(UUID id) throws NoteNotFoundException;

    void update(Note note) throws NoteNotFoundException;
}
