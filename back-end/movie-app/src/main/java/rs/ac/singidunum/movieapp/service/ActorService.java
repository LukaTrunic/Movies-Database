package rs.ac.singidunum.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.movieapp.entity.Actor;
import rs.ac.singidunum.movieapp.entity.Movie;
import rs.ac.singidunum.movieapp.repository.ActorRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository repository;

    // Retrieves all actors where the deletedAt field is null
    public List<Actor> getAllActors(){
        return repository.findAllActorsByDeletedAtIsNull();
    }

    // Retrieves an actor by ID where the deletedAt field is null
    public Actor getActorById(Integer id){
        return repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
    }

    // Creates a new actor
    public Actor createActor(Actor actor) {
        actor.setId(null);
        actor.setDeletedAt(null);

        return repository.save(actor);
    }

    // Updates an existing actor
    public Actor updateActor(Integer id, Actor actor){
        actor.setId(id);
        actor.setUpdatedAt(LocalDateTime.now());
        actor.setDeletedAt(null);

        return repository.save(actor);
    }

    // Deletes an actor by setting the deletedAt field
    public void deleteActor(Integer id){
        Actor actor = getActorById(id);
        actor.setDeletedAt(LocalDateTime.now());
        repository.save(actor);
    }
}
