package schoolmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import schoolmanager.Course.Course;
import schoolmanager.Course.CourseRepository;
import schoolmanager.Student.Student;
import schoolmanager.Student.StudentRepository;

@SpringBootApplication
public class SchoolmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmanagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoStudent(StudentRepository studentRepository, CourseRepository courseRepository){
		return (args) -> {
			courseRepository.save(new Course("comp400"));
			courseRepository.save(new Course("math423"));
			courseRepository.save(new Course("phys123"));
			courseRepository.save(new Course("eng123"));

			studentRepository.save(new Student("DANIEL", "LI"));
			studentRepository.save(new Student("CATHERINE", "LI"));
			studentRepository.save(new Student("JANE", "DOE"));
			studentRepository.save(new Student("Jane", "Joe"));
		};
	}

}
