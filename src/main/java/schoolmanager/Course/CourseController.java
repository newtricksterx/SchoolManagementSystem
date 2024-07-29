package schoolmanager.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import schoolmanager.Exceptions.CourseDoesNotExistException;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String showAllCourses(Model model){
        List<CourseDTO> courseDTOList = courseService.getAllCourses();
        model.addAttribute("courses", courseDTOList);
        return "courses";
    }

    @PostMapping("/delete_course/{id}")
    public String deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

    /*
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long courseId){
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseDoesNotExistException(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId){
        courseRepository.deleteById(courseId);
    }

     */
}
