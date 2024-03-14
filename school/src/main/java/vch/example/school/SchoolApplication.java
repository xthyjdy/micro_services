package vch.example.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import static vch.example.school.Helper.l;

@EnableFeignClients
@SpringBootApplication
public class SchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
		l("---------------->");
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			SchoolRepository repository
	) {
		return args -> {
			for (int i = 1; i <= 4; i++) {
				repository.save(
						SchoolEntity.builder()
								.name("school_" + i)
								.email("school_" + i + "@x.com")
								.build()
				);
			}
		};
	}

}
