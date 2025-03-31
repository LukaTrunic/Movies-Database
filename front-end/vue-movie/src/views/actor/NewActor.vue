<script setup lang="ts">
import { useGo } from "@/hooks/go.hook";
import { MainService } from "@/services/main.service";
import Loading from "@/components/Loading.vue";
import { ref } from "vue";
import type { MovieModel } from "@/models/movie.model";

const go = useGo();
const actor: any = {};

const movies = ref<MovieModel[]>();
MainService.getAllMovies().then((rsp) => (movies.value = rsp.data));

// Function to save a new actor
function save() {
  const payload = actor;
  actor.movies.map((mov: any) => {
    id: mov.id;
  });
  MainService.saveActor(payload)
    .then((rsp) => {
      console.log(rsp);
      go("/actor");
    })
    .catch((e) => {
      console.log(e.message);
    });
}

// Function to check if a movie is already selected
function contains(movie: MovieModel) {
  if (actor.movies == undefined) return false;
  return (actor.movies as MovieModel[]).map((m) => m.id).includes(movie.id);
}

// Function to handle movie selection
function handleSelect(movie: MovieModel) {
  if (contains(movie)) {
    actor.movies = (actor.movies as MovieModel[]).filter(
      (m) => m.id != movie.id
    );
    return;
  }

  if (actor.movies == undefined) actor.movies = [];
  actor.movies.push(movie);
}
</script>

<template>
  <h1 class="h3">Edit Actor:</h1>
  <RouterLink class="btn btn-outline-danger mb-3" to="/movie">
    <i class="fa-solid fa-arrow-left-long"></i> List of Actors
  </RouterLink>
  <div v-if="actor">
    <div class="mb-3">
      <label for="fullname" class="form-label">Full name:</label>
      <input
        type="text"
        class="form-control"
        id="fullname"
        v-model="actor.fullName"
      />
    </div>
    <div class="mb-3" v-if="movies">
      <label class="form-label">Movies:</label>
      <div class="form-check" v-for="movie in movies">
        <input
          class="form-check-input"
          type="checkbox"
          :id="'movie-' + movie.id"
          :checked="contains(movie)"
          @change="handleSelect(movie)"
        />
        <label class="form-check-label" :for="'movie-' + movie.id">
          {{ movie.title }}
        </label>
      </div>
    </div>
    <button type="button" class="btn btn-outline-primary" @click="save">
      Apply Changes
    </button>
  </div>
  <Loading v-else />
</template>
