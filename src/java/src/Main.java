package src;

public class Main{
    public static void main(String[] args){

        User user = new User("MaxiRage");

        Saveable saveable = new Persister(user);
        saveable.save();

        Reportable reportable = new ReportUser(user);
        reportable.report();
    }
}