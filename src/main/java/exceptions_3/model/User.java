package exceptions_3.model;

import exceptions_3.constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {

    private String name;
    private String surname;
    private String middleName;
    private LocalDate birthday;
    private long tel;
    private Gender gender;
}
