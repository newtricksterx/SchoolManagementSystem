package schoolmanager.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<CourseDTO> getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public CourseDTO mapToDTO(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setCapacity(course.getCapacity());
        courseDTO.setClassCode(course.getClassCode());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setCreditWorth(course.getCreditWorth());

        return courseDTO;
    }
}
