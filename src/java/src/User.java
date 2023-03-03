package src;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private String name;

    public void save() {
        Persister persister = new Persister(this);
        persister.save();
    }

    public void report() {
        System.out.println("Report for user: " + name);
    }
}