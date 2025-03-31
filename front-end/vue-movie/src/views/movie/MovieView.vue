<script setup lang="ts">
import { ref } from "vue";
import type { MovieModel } from "@/models/movie.model";
import { MainService } from "@/services/main.service";
import { useGo } from "@/hooks/go.hook";
import Loading from "@/components/Loading.vue";

const movies = ref<MovieModel[]>();
MainService.getAllMovies().then((rsp) => (movies.value = rsp.data));

const go = useGo();

// Function to delete a movie
function deleteMovie(movie: MovieModel) {
  if (confirm("Are you sure")) {
    MainService.deleteMovie(movie.id)
      .then((rsp) => {
        if (movies.value == undefined) return;
        movies.value = movies.value.filter((s) => s.id != movie.id);
      })
      .catch((e) => console.log(e));
  }
}
</script>

<template>
  <h1 class="h3">Movies</h1>
  <RouterLink class="btn btn-outline-danger mb-3" to="/movie/new">
    <i class="fa-solid fa-plus"></i> Create a new movie
  </RouterLink>
  <table class="table table-striped table-hover" v-if="movies">
    <thead>
      <tr>
        <th scope="col">RELEASE YEAR</th>
        <th scope="col">TITLE</th>
        <th scope="col">GENRE</th>
        <th scope="col">RATING</th>
        <th scope="col">CREATED AT</th>
        <th scope="col">UPDATED AT</th>
        <th scope="col">ACTIONS</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="movie in movies" :movie-id="movie.id">
        <th scope="row">{{ movie.releaseYear }}</th>
        <td>{{ movie.title }}</td>
        <td>{{ movie.genre }}</td>
        <td>{{ movie.rating }}</td>
        <td>{{ new Date(movie.createdAt).toLocaleDateString("sr") }}</td>
        <td>
          <span v-if="movie.updatedAt">
            {{ new Date(movie.updatedAt).toLocaleDateString("sr") }}</span
          >
          <i class="fa-solid fa-square-xmark" v-else></i>
        </td>
        <td>
          <div class="btn-group">
            <button
              type="button"
              class="btn btn-sm btn-success"
              @click="() => go(`/movie/${movie.id}/edit`)"
            >
              <i class="fa-solid fa-pen"></i>
            </button>
            <button
              type="button"
              class="btn btn-sm btn-danger"
              @click="deleteMovie(movie)"
            >
              <i class="fa-solid fa-ban"></i>
            </button>
          </div>
        </td>
      </tr>
    </tbody>
  </table>
  <Loading v-else />
</template>
