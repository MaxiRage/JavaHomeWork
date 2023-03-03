package model;

import java.util.List;

public interface NotesMapper {
    String map(List<Note> list);

    List<Note> map(String text) throws Exception;

}
