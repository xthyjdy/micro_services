package vch.example.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {//{ "firstName": "fn1", "email":"e1@.com", "schoolId":1 }
    private String firstName;
    private String email;
}