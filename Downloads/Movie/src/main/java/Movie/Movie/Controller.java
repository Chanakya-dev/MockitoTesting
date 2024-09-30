package Movie.Movie;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final MovieService svc;
 
   
   public Controller(MovieService svc) {
        this.svc = svc;
    }


@PostMapping("save")
    public MovieApp savedata(@RequestBody MovieApp p){
     return svc.savedata(p);
    }

}
