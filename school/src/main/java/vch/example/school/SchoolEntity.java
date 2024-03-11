package vch.example.school;

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
@Table(name = "SCHOOL_TBL")
public class SchoolEntity {//{ "name": "def", "email":"sch1@.com" }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;

//    @ManyToOne
//    @JoinColumn(name = "school_id")
//    private Long schoolId;
//    private Long schoolId;
}
