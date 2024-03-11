package vch.example.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static vch.example.student.Helper.l;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
		l("---------------->");
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			for (int i = 1; i <= 4; i++) {
				StudentEntity student1 = StudentEntity.builder()
						.firstName("Student_" + i)
						.email("Student_" + i)
						.schoolId((long)i)
						.build();
				repository.save(student1);
				StudentEntity student2 = StudentEntity.builder()
						.firstName("Student_" + i + "" + i)
						.email("Student_" + i + "" + i)
						.schoolId((long)i)
						.build();
				repository.save(student2);
				StudentEntity student3 = StudentEntity.builder()
						.firstName("Student_" + i + "" + i  + "" + i)
						.email("Student_" + i + "" + i + "" + i)
						.schoolId((long)i)
						.build();
				repository.save(student3);
			}
		};
	}
}
