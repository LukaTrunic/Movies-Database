<script setup lang="ts">
import { useGo } from "@/hooks/go.hook";
import { MainService } from "@/services/main.service";
import Loading from "@/components/Loading.vue";

const go = useGo();
const movie: any = {};

// Function to save a new movie
function save() {
  MainService.saveMovie(movie)
    .then((rsp) => {
      console.log(rsp);
      go("/movie");
    })
    .catch((e) => {
      console.log(e.message);
    });
}
</script>

<template>
  <h1 class="h3">Edit Movie:</h1>
  <RouterLink class="btn btn-outline-danger mb-3" to="/movie">
    <i class="fa-solid fa-arrow-left-long"></i> List of Movies
  </RouterLink>
  <div v-if="movie">
    <div class="mb-3">
      <label for="releaseyear" class="form-label">Release year:</label>
      <input
        type="number"
        class="form-control"
        id="releaseyear"
        v-model="movie.releaseYear"
      />
    </div>
    <div class="mb-3">
      <label for="title" class="form-label">Title:</label>
      <input
        type="text"
        class="form-control"
        id="title"
        v-model="movie.title"
      />
    </div>
    <div class="mb-3">
      <label for="genre" class="form-label">Genre:</label>
      <input
        type="text"
        class="form-control"
        id="genre"
        v-model="movie.genre"
      />
    </div>
    <div class="mb-3">
      <label for="rating" class="form-label">Rating:</label>
      <input
        type="number"
        class="form-control"
        id="rating"
        v-model="movie.rating"
      />
    </div>
    <button type="button" class="btn btn-outline-primary" @click="save">
      Apply Changes
    </button>
  </div>
  <Loading v-else />
</template>
