package vch.example.school.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vch.example.school.Student;

import java.util.List;

@FeignClient(name = "student-service", url = "${my_config.students-url}")
public interface StudentClient {
    @GetMapping("/school/{school-id}")
    List<Student> findAllStudentsBySchool(@PathVariable("school-id") long schoolId);
}
