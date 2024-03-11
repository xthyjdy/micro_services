package vch.example.school;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class SchoolService {
    private final SchoolRepository repository;

    public SchoolEntity saveSchool(SchoolEntity school) {
        SchoolEntity savedSchool = repository.save(school);
        return savedSchool;
    }

    public List<SchoolEntity> getAllSchool() {
        return repository.findAll();
    }
}
