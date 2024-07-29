package schoolmanager.Student;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private int yearGroup;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String firstName, String lastName, LocalDate dob, int yearGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.yearGroup = yearGroup;
    }
}
