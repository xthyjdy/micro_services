package vch.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vch.example.school.client.StudentClient;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolService {
    private final SchoolRepository repository;
    private final StudentClient client;

    public SchoolEntity saveSchool(SchoolEntity school) {
        SchoolEntity savedSchool = repository.save(school);
        return savedSchool;
    }

    public List<SchoolEntity> getAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse getSchoolWithStudents(long schoolId) {
        SchoolEntity school = repository.findById(schoolId)
                .orElse(
                        SchoolEntity.builder()
                                .name("NOT FOUND")
                                .email("NOT FOUND")
                                .build()
                );
        List<Student> students = client.findAllStudentsBySchool(schoolId);//find all students from micro services
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
