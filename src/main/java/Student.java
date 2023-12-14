import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class Student implements Serializable {
    public String name;
    public int age;
    public transient double GPA;
}