package schoolmanager.Student;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import schoolmanager.Course.Course;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Student's first name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Student's last name cannot be empty")
    private String lastName;
    private LocalDate dob;
    private int yearGroup;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courseList;

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
        this.lastName =  lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
    }

    public Student(String firstName, String lastName, LocalDate dob, int yearGroup) {
        this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();;
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
        this.dob = dob;
        this.yearGroup = yearGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", yearGroup=" + yearGroup +
                '}';
    }
}
