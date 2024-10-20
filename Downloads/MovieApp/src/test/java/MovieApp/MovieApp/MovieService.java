package MovieApp.MovieApp;

import MovieApp.MovieApp.Entity.Movie;
import MovieApp.MovieApp.Repository.MovieRepository;
import MovieApp.MovieApp.Service.MovieService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    private Movie movie;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        movie = new Movie(1L, "Inception", "Sci-Fi", true, "poster.jpg", LocalDate.of(2010, 7, 16));
    }

    @Test
    void testSavedMovie() {
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        Movie savedMovie = movieService.saved(movie);

        assertNotNull(savedMovie);
        assertEquals("Inception", savedMovie.getTitle());
        verify(movieRepository, times(1)).save(any(Movie.class));
    }

    @Test
    void testGetPopularMovies() {
        when(movieRepository.findByIsPopularTrue()).thenReturn(Arrays.asList(movie));

        List<Movie> popularMovies = movieService.getPopularMovies();

        assertNotNull(popularMovies);
        assertEquals(1, popularMovies.size());
        assertTrue(popularMovies.get(0).isPopular());
        verify(movieRepository, times(1)).findByIsPopularTrue();
    }

    @Test
    void testGetMoviesByGenre() {
        when(movieRepository.findByGenre("Sci-Fi")).thenReturn(Arrays.asList(movie));

        List<Movie> moviesByGenre = movieService.getMoviesByGenre("Sci-Fi");

        assertNotNull(moviesByGenre);
        assertEquals(1, moviesByGenre.size());
        assertEquals("Sci-Fi", moviesByGenre.get(0).getGenre());
        verify(movieRepository, times(1)).findByGenre("Sci-Fi");
    }

    @Test
    void testSearchMovieByName() {
        when(movieRepository.Search("Inception")).thenReturn(Arrays.asList(movie));

        List<Movie> searchResults = movieService.search("Inception");

        assertNotNull(searchResults);
        assertEquals(1, searchResults.size());
        assertEquals("Inception", searchResults.get(0).getTitle());
        verify(movieRepository, times(1)).Search("Inception");
    }

    @Test
    void testSaveBulkMovies() {
        List<Movie> movies = Arrays.asList(movie);
        when(movieRepository.saveAll(anyList())).thenReturn(movies);

        List<Movie> savedMovies = movieService.savebulk(movies);

        assertNotNull(savedMovies);
        assertEquals(1, savedMovies.size());
        verify(movieRepository, times(1)).saveAll(anyList());
    }

    @Test
    void testFindMovieByName() {
        when(movieRepository.findByName("Inception")).thenReturn(movie);

        Movie foundMovie = movieService.findbyName("Inception");

        assertNotNull(foundMovie);
        assertEquals("Inception", foundMovie.getTitle());
        verify(movieRepository, times(1)).findByName("Inception");
    }

    @Test
    void testGetUpcomingMovies() {
        LocalDate today = LocalDate.now();
        when(movieRepository.findUpcomingMovies(today)).thenReturn(Arrays.asList(movie));

        List<Movie> upcomingMovies = movieService.getUpcomingMovies();

        assertNotNull(upcomingMovies);
        assertEquals(1, upcomingMovies.size());
        verify(movieRepository, times(1)).findUpcomingMovies(today);
    }

    @Test
    void testGetMoviesByDesc() {
        LocalDate today = LocalDate.now();
        when(movieRepository.findUpcomingMoviesDescending(today)).thenReturn(Arrays.asList(movie));

        List<Movie> upcomingMoviesDesc = movieService.getMoviesbydesc();

        assertNotNull(upcomingMoviesDesc);
        assertEquals(1, upcomingMoviesDesc.size());
        verify(movieRepository, times(1)).findUpcomingMoviesDescending(today);
    }

    @Test
    void testGetAllMovies() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Movie> page = new PageImpl<>(Arrays.asList(movie));
        when(movieRepository.findAll(pageable)).thenReturn(page);

        Page<Movie> allMovies = movieService.getAllMovies(0, 5);

        assertNotNull(allMovies);
        assertEquals(1, allMovies.getContent().size());
        verify(movieRepository, times(1)).findAll(pageable);
    }

    @Test
    void testDeleteMovie() {
        doNothing().when(movieRepository).deleteById(1L);

        String result = movieService.deletemovie(1L);

        assertEquals("Deleted Sucessfully", result);
        verify(movieRepository, times(1)).deleteById(1L);
    }
}
