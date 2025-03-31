// Movie.java
package rs.ac.singidunum.movieapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "movie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Movie {
    // Specified all columns in the table
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer releaseYear;
    private String genre;
    private Double rating;

    // Many 2 many relationship with Actor
    @ManyToMany(mappedBy = "movies")
    @JsonIgnore
    List<Actor> likes;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    @JsonIgnore
    private LocalDateTime deletedAt;
}
