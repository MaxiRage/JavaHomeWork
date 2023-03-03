package src;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Persister implements Saveable{
    private User user;

    public void save(){
        System.out.println("Save user: " + user.getName());
    }
}