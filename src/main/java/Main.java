import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = Student.builder()
                .name("Max")
                .age(28)
                .GPA(4.8)
                .build();

        try (FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream("data.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Объект сериализован");

            student = (Student) objectInputStream.readObject();
            System.out.println("Объект десериализован");
        }
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний бал: " + student.getGPA());
    }
}
/*
Transient-свойства не сохраняются, т.к. считаются временными и не являются частью состояния объекта, соответственно не были сериализованны и десериализованны.
 */