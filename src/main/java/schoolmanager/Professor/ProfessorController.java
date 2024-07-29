package schoolmanager.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schoolmanager.Exceptions.ProfessorDoesNotExistException;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/professors")
    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }

    @GetMapping("/professors/{id}")
    public Professor getProfessor(@PathVariable("id") Long professorId){
        return professorRepository.findById(professorId)
                .orElseThrow(() -> new ProfessorDoesNotExistException(professorId));
    }

    @PostMapping("/professors")
    public void addProfessor(@RequestBody Professor professor){
        professorRepository.save(professor);
    }

    @PutMapping("/professors")
    public Professor updateProfessor(@RequestBody Professor professor){
        return professorRepository.save(professor);
    }

    @DeleteMapping("/professors/{professorId}")
    public void deleteProfessor(@PathVariable("professorId") Long professorId){
        professorRepository.deleteById(professorId);
    }
}
