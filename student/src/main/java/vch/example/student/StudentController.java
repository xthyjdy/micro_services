package vch.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public List<StudentEntity> getStudents() {
        return service.getAllStudents();
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
