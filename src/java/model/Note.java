package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Note {

    private String id;
    private String head;
    private String text;
    public Note(String head, String text) {
        this("", head, text);
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nhead: \"" + head + '\"' +
                ", text: \"" + text + "\"";
    }
}
