package com.notedata.service.impl;

import com.notedata.entity.Note;
import com.notedata.exception.NoteNotFoundException;
import com.notedata.repositoriy.NoteRepository;
import com.notedata.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note getById(UUID id) throws NoteNotFoundException {
        Note note = Optional.ofNullable(noteRepository.findById(id))
                .get()
                .orElseThrow(() -> new NoteNotFoundException());
        return note;
    }

    @Override
    public void deleteById(UUID id) throws NoteNotFoundException {
        noteRepository.deleteById(id);
    }

    @Override
    public void update(Note note) throws NoteNotFoundException {
        noteRepository.save(note);
    }
}
