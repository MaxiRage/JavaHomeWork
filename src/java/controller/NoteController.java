package controller;

import lombok.AllArgsConstructor;
import model.Fields;
import model.Repository;
import model.Note;

import java.util.List;

@AllArgsConstructor
public class NoteController {

    private final Repository repository;

    public void saveNote(Note note) throws Exception {
        repository.createNote(note);
    }

    public void deleteNote(String noteId) throws Exception {

        Note noteFind = getNoteById(noteId);

        if (noteFind == null) {
            throw new Exception("Note not found");
        }

        repository.deleteNote(noteFind);
    }

    public void updateNote(Note note, Fields field, Object param) throws Exception {
        repository.updateNote(note, field, param);
    }

    public Note readNote(String noteId) throws Exception {
        Note noteFind = getNoteById(noteId);

        if (noteFind == null) {
            throw new Exception("Note not found");
        }

        return noteFind;
    }

    public List<Note> getNotes() throws Exception {
        return repository.getAllNotes();
    }

    public Note getNoteById(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        Note noteFind = null;
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                noteFind = note;
                break;
            }
        }
        return noteFind;
    }


}
