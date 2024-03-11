package vch.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    @GetMapping
    public ResponseEntity<List<SchoolEntity>> getSchool() {
        return ResponseEntity.ok(service.getAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> getSchoolWithStudents(
            @PathVariable("school-id") long schoolId
    ) {
        return ResponseEntity.ok(service.getSchoolWithStudents(schoolId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SchoolEntity> saveSchool(
            @RequestBody SchoolEntity school
    ) {
        SchoolEntity savedSchool = service.saveSchool(school);
        return ResponseEntity.ok(savedSchool);
    }
}
