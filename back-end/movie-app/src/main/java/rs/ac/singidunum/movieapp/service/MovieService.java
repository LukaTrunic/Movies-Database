package rs.ac.singidunum.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.movieapp.entity.Movie;
import rs.ac.singidunum.movieapp.repository.MovieRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    // Retrieves all movies where the deletedAt field is null
    public List<Movie> getAllMovies(){
        return repository.findAllMoviesByDeletedAtIsNull();
    }

    // Retrieves a movie by ID where the deletedAt field is null
    public Movie getMovieById(Integer id){
        return repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
    }

    // Creates a new movie
    public Movie createMovie(Movie movie) {
        movie.setId(null);
        movie.setDeletedAt(null);

        return repository.save(movie);
    }

    // Updates an existing movie
    public Movie updateMovie(Integer id, Movie movie){
        movie.setId(id);
        movie.setUpdatedAt(LocalDateTime.now());
        movie.setDeletedAt(null);

        return repository.save(movie);
    }

    // Deletes a movie by setting the deletedAt field
    public void deleteMovie(Integer id){
        Movie movie = getMovieById(id);
        movie.setDeletedAt(LocalDateTime.now());
        repository.save(movie);
    }
}
