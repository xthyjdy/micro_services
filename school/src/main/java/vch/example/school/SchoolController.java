package vch.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    @GetMapping
    public List<SchoolEntity> getSchool() {
        return service.getAllSchool();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolEntity saveSchool(
            @RequestBody SchoolEntity school
    ) {
        SchoolEntity savedSchool = service.saveSchool(school);
        return savedSchool;
    }
}
