package MovieApp.MovieApp.Entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private boolean isPopular;
    private String poster;
     private LocalDate releaseDate; 
     
    

    public void setPopular(boolean isPopular) {
        this.isPopular = isPopular;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    // Constructors
    public Movie() {
    }

    public Movie(String title, String genre, boolean isPopular,String poster,LocalDate date) {
        this.title = title;
        this.genre = genre;
        this.isPopular = isPopular;
        this.poster=poster;
        this.releaseDate=date;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean getIsPopular() {
        return isPopular;
    }

    public void setIsPopular(boolean isPopular) {
        this.isPopular = isPopular;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}