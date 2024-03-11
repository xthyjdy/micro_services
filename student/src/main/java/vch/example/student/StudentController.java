package vch.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<StudentEntity>> getStudentsBySchoolId(
            @PathVariable("school-id") long schoolId
    ) {
        return ResponseEntity.ok(service.getStudentsBySchoolId(schoolId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity saveStudent(
            @RequestBody StudentEntity student
    ) {
        StudentEntity savedStudent = service.saveStudent(student);
        return savedStudent;
    }
}
