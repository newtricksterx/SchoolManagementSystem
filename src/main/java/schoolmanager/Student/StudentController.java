package schoolmanager.Student;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import schoolmanager.Exceptions.StudentDoesNotExistException;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/add_student")
    public String showAddStudentForm(Model model){
        model.addAttribute("student", new StudentDTO());
        return "add_student";
    }

    @GetMapping("/students")
    public String showAllStudents(Model model){
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping("/add_student/save")
    public String addStudent(@Valid @ModelAttribute("student") StudentDTO studentDTO, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("student", new StudentDTO());
            return "add_student";
        }

        studentService.addStudent(studentDTO);
        return "redirect:/students";
    }

    @PostMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    /**
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") Long studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentDoesNotExistException(studentId));
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        studentRepository.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentRepository.deleteById(studentId);
    }
    **/
}
