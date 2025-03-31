package rs.ac.singidunum.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.movieapp.entity.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    // Finds all movies where the deletedAt field is null
    List<Movie> findAllMoviesByDeletedAtIsNull();

    // Finds a movie by ID where the deletedAt field is null
    Optional<Movie> findByIdAndDeletedAtIsNull(Integer id);

}
