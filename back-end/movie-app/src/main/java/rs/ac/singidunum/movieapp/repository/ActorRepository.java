package rs.ac.singidunum.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.movieapp.entity.Actor;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    // Finds all actors where the deletedAt field is null
    List<Actor> findAllActorsByDeletedAtIsNull();

    // Finds an actor by ID where the deletedAt field is null
    Optional<Actor> findByIdAndDeletedAtIsNull(Integer id);

}
