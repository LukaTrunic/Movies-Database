package rs.ac.singidunum.movieapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.movieapp.entity.Movie;
import rs.ac.singidunum.movieapp.service.MovieService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    // Handles GET request to retrieve all movies
    @GetMapping
    public List<Movie> getAllMovies(){
        return service.getAllMovies();
    }

    // Handles GET request to retrieve a movie by ID
    @GetMapping(path = "/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return service.getMovieById(id);
    }

    // Handles POST request to create a new movie
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie){
        return service.createMovie(movie);
    }

    // Handles PUT request to update an existing movie
    @PutMapping(path = "/{id}")
    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie){
        return service.updateMovie(id, movie);
    }

    // Handles DELETE request to delete a movie
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void deleteMovie(@PathVariable Integer id){
        service.deleteMovie(id);
    }
}
