package Spring_Boot.Spring_Boot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/hi")
    public String name(){
    return "Hello World!";
    }
    @PostMapping("/Posting")
    public void name(@RequestParam String name){
       String names=name;
       System.out.println("Hello  : "+names);
    }
    @PostMapping("/Req/{name}")
    public void name1(@PathVariable String name){
        String names=name;
        System.out.println("Hello  : "+names);
     }
     
}
