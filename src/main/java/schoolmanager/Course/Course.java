package schoolmanager.Course;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import schoolmanager.Professor.Professor;
import schoolmanager.Student.Student;

import java.util.List;

@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classCode;
    private String description;
    private int creditWorth;
    private int capacity;

    @ManyToMany
    private List<Student> studentList;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Course() {
    }

    public Course(String classCode) {
        this.classCode = classCode.toUpperCase();
    }

    public Course(String classCode, String description, int creditWorth, int capacity) {
        this.classCode = classCode.toUpperCase();
        this.description = description;
        this.creditWorth = creditWorth;
        this.capacity = capacity;
    }

    public void setClassCode(String classCode){
        this.classCode = classCode.toUpperCase();
    }

    public void setCreditWorth(int creditWorth){
        if(creditWorth <= 4) {
            this.creditWorth = creditWorth;
        }
    }
}
