package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nИмя: %s\n,Фамилия: %s\n,Телефон: %s\n", id, firstName, lastName, phone);
    }
}
