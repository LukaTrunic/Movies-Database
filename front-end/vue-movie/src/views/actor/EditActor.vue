<script setup lang="ts">
import { useGo } from "@/hooks/go.hook";
import type { ActorModel } from "@/models/actor.model";
import { MainService } from "@/services/main.service";
import { ref } from "vue";
import { useRoute } from "vue-router";
import Loading from "@/components/Loading.vue";
import type { MovieModel } from "@/models/movie.model";

const go = useGo();
const route = useRoute();
const id = route.params.id as any as number;

const actor = ref<ActorModel>();
MainService.getActorById(id).then((rsp) => (actor.value = rsp.data));

const movies = ref<MovieModel[]>();
MainService.getAllMovies().then((rsp) => (movies.value = rsp.data));

// Function to save changes to the actor
function save() {
  if (actor.value == undefined) return;

  const payload = actor.value as any;
  actor.value.movies.map((mov) => {
    id: mov.id;
  });

  MainService.updateActor(id, payload)
    .then((data) => {
      console.log(data);
      go("/actor");
    })
    .catch((e) => {
      alert(e.message);
    });
}

// Function to handle movie selection
function handleSelect(movie: MovieModel) {
  if (actor.value == undefined) return;
  if (contains(movie)) {
    actor.value.movies = actor.value.movies.filter((m) => m.id != movie.id);
    return;
  }

  actor.value.movies.push(movie);
}

// Function to check if a movie is already selected
function contains(movie: MovieModel) {
  if (actor.value == undefined) return false;
  return actor.value.movies.map((m) => m.id).includes(movie.id);
}
</script>

<template>
  <h1 class="h3">Edit Actor:</h1>
  <RouterLink class="btn btn-outline-danger mb-3" to="/actor">
    <i class="fa-solid fa-arrow-left-long"></i> List of Actors
  </RouterLink>
  <div v-if="actor">
    <div class="mb-3">
      <label for="idx" class="form-label">Actor ID:</label>
      <input
        type="number"
        class="form-control"
        id="idx"
        v-model="actor.id"
        disabled
      />
    </div>
    <div class="mb-3">
      <label for="fullname" class="form-label">Full Name:</label>
      <input
        type="text"
        class="form-control"
        id="fullname"
        v-model="actor.fullName"
      />
    </div>
    <div class="mb-3">
      <label for="created" class="form-label">Created At:</label>
      <input
        type="text"
        class="form-control"
        id="created"
        :value="new Date(actor.createdAt)"
        disabled
      />
    </div>
    <div class="mb-3">
      <label for="updated" class="form-label">Updated At:</label>
      <input
        type="text"
        class="form-control"
        id="updated"
        :value="actor.updatedAt ? new Date(actor.updatedAt) : 'N/A'"
        disabled
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
