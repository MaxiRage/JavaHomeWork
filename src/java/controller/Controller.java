package controller;

import model.Fields;
import model.Note;

import java.util.List;

public interface Controller {
    List<Note> getNotes() throws Exception;
    Note readNote(String noteId) throws Exception;
    void saveNote(Note note) throws Exception;
    void deleteNote(String noteId) throws Exception;
    void updateNote(Note note, Fields field, Object param) throws Exception;
    Note getNoteById(String noteId) throws Exception;
}
