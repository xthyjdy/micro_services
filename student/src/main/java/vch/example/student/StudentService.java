package vch.example.student;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentEntity saveStudent(StudentEntity student) {
        StudentEntity savedStudent = repository.save(student);
        return savedStudent;
    }

    public List<StudentEntity> getAllStudents() {
        return repository.findAll();
    }

    public List<StudentEntity> getStudentsBySchoolId(long schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}
