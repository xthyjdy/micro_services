package vch.example.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "STUDENT_TBL")
public class StudentEntity {//{ "firstName": "fn1", "email":"e1@.com", "schoolId":1 }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    @Column(unique = true, nullable = false)
    private String email;

//    @ManyToOne
//    @JoinColumn(name = "school_id")
//    private Long schoolId;
    private Long schoolId;
}
