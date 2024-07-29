package schoolmanager.HTML;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import schoolmanager.Student.Student;
import schoolmanager.Student.StudentDTO;
import schoolmanager.Student.StudentService;

import java.util.List;

@Controller
public class AuthController {

    /*
    @Autowired
    StudentService studentService;

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
        return "redirect:/add_student/success";
    }
    */
}
