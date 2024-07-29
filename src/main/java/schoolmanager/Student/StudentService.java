package schoolmanager.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolmanager.Course.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setDob(studentDTO.getDob());
        student.setYearGroup(studentDTO.getYearGroup());

        //System.out.println(student.toString());

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }

    public List<StudentDTO> getAllStudents(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents.stream().map(this::mapToDTO).collect(Collectors.toList());
    }


    public StudentDTO mapToDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setDob(student.getDob());
        studentDTO.setYearGroup(student.getYearGroup());

        return studentDTO;
    }
}
