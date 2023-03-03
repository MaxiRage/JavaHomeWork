package src;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReportUser implements Reportable{

    private User user;

    public void report(){
        System.out.println("Report for user: " + user.getName());
    }

}