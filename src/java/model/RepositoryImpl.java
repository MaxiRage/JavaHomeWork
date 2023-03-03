package model;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RepositoryImpl implements Repository {

    private final NotesMapper mapper;
    private final FileOperation fileOperation;

    @Override
    public List<Note> getAllNotes() throws Exception {
        String text = fileOperation.readText();
        return mapper.map(text);
    }

    @Override
    public void createNote(Note note) throws Exception {

        List<Note> notes = getAllNotes();
        int maxId = 0;
        for (Note currentNote : notes) {
            int id = Integer.parseInt(currentNote.getId());
            if (maxId < id) {
                maxId = id;
            }
        }
        int newId = maxId + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);

        String text = mapper.map(notes);
        fileOperation.saveText(text);

    }

    @Override
    public void updateNote(Note note, Fields field, Object param) throws Exception {
        if (field == Fields.HEAD) {
            note.setHead((String) param);
        } else if (field == Fields.TEXT) {
            note.setText((String) param);
        }
        saveNote(note);
    }

    @Override
    public void deleteNote(Note note) throws Exception {
        List<Note> list = getAllNotes();

        int findIndex = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(note.getId())) {
                findIndex = i;
                break;
            }
        }
        if (findIndex > -1) {
            list.remove(findIndex);
        }
        String text = mapper.map(list);
        fileOperation.saveText(text);

    }

    @Override
    public void saveNote(Note note) throws Exception {

        if (note == null) {
            return;
        }
        List<Note> list = getAllNotes();

        for (int i = 0; i < list.size(); i++) {
            Note currentNote = list.get(i);
            if (currentNote.getId().equals(note.getId())) {
                list.set(i, note);
                break;
            }
        }
        String text = mapper.map(list);
        fileOperation.saveText(text);
    }
}