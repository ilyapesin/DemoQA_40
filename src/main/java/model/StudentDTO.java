package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class StudentDTO {
    String firstName;
    String lastName;
    String email;
    Gender gender;
    String phone;
    String birthday;
    String subjects;
    List <Hobby>hobbies;
    String address;
    String state;
    String city;

}
