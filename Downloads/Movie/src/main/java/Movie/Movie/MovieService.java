package Movie.Movie;

import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
  
    private MovieRepository m;

    
    public MovieService(MovieRepository m) {
        this.m = m;
    }


    public MovieApp savedata(MovieApp movie){
      
        return m.save(movie);

    }

}
