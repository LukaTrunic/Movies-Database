package rs.ac.singidunum.movieapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.movieapp.entity.Actor;
import rs.ac.singidunum.movieapp.service.ActorService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService service;

    // Handles GET request to retrieve all actors
    @GetMapping
    public List<Actor> getAllActors(){
        return service.getAllActors();
    }

    // Handles GET request to retrieve an actor by ID
    @GetMapping(path = "/{id}")
    public Actor getActorById(@PathVariable Integer id) {
        return service.getActorById(id);
    }

    // Handles POST request to create a new actor
    @PostMapping
    public Actor createActor(@RequestBody Actor actor){
        return service.createActor(actor);
    }

    // Handles PUT request to update an existing actor
    @PutMapping(path = "/{id}")
    public Actor updateActor(@PathVariable Integer id, @RequestBody Actor actor){
        return service.updateActor(id, actor);
    }

    // Handles DELETE request to delete an actor
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void deleteActor(@PathVariable Integer id){
        service.deleteActor(id);
    }
}
