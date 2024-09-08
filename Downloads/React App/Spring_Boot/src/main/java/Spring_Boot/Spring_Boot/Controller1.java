package Spring_Boot.Spring_Boot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Con1")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller1 {
    @Autowired
    private Repo r;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student s) {
        return new ResponseEntity<>(r.save(s), HttpStatus.CREATED);
    }

    @GetMapping("getData/{eid}")
    public ResponseEntity<Student> getbyid(@PathVariable Integer eid) {
        Optional<Student> student = r.findById(eid);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("del/{eid}")
    public ResponseEntity<String> del(@PathVariable Integer eid) {
        r.deleteById(eid);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getall() {
        List<Student> students = r.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
