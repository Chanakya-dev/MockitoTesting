package MovieApp.MovieApp.Service;



import MovieApp.MovieApp.Entity.Movie;
import MovieApp.MovieApp.Repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {
   

    @Autowired
    private  MovieRepository movieRepository;


  
    public Movie saved(Movie m){
     
        
        return movieRepository.save(m);
    }

    public List<Movie> getPopularMovies() {
        return movieRepository.findByIsPopularTrue();
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }
    public List<Movie> search(String name){
        return movieRepository.Search(name);
    }
    public List<Movie> savebulk(List<Movie>m){
        return movieRepository.saveAll(m);
    }

    public Movie findbyName(String name){
        return movieRepository.findByName(name);
    }
    
    public List<Movie> getUpcomingMovies() {
        LocalDate today = LocalDate.now();
        return movieRepository.findUpcomingMovies(today);
}
public List<Movie> getMoviesbydesc() {
    LocalDate today = LocalDate.now();
    return movieRepository.findUpcomingMoviesDescending(today);
}
public String deletemovie(Long id){
    movieRepository.deleteById(id);
    return "Deleted Sucessfully";
}
}