<script setup lang="ts">
import { ref } from "vue";
import { MainService } from "@/services/main.service";
import { useGo } from "@/hooks/go.hook";
import type { ActorModel } from "@/models/actor.model";
import Loading from "@/components/Loading.vue";

const actors = ref<ActorModel[]>();
MainService.getAllActors().then((rsp) => (actors.value = rsp.data));

const go = useGo();

// Function to delete an actor
function deleteActor(actor: ActorModel) {
  if (confirm("Are you sure")) {
    MainService.deleteActor(actor.id)
      .then((rsp) => {
        if (actors.value == undefined) return;
        actors.value = actors.value.filter((s) => s.id != actor.id);
      })
      .catch((e) => console.log(e));
  }
}
</script>

<template>
  <h1 class="h3">Actors</h1>
  <RouterLink class="btn btn-outline-danger mb-3" to="/actor/new">
    <i class="fa-solid fa-plus"></i> Create a new actor
  </RouterLink>
  <table class="table table-striped table-hover" v-if="actors">
    <thead>
      <tr>
        <th scope="col">FULL NAME</th>
        <th scope="col">CREATED AT</th>
        <th scope="col">UPDATED AT</th>
        <th scope="col">ACTIONS</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="actor in actors" :actor-id="actor.id">
        <th scope="row">{{ actor.fullName }}</th>
        <td>{{ new Date(actor.createdAt).toLocaleDateString("sr") }}</td>
        <td>
          <span v-if="actor.updatedAt">
            {{ new Date(actor.updatedAt).toLocaleDateString("sr") }}</span
          >
          <i class="fa-solid fa-square-xmark" v-else></i>
        </td>
        <td>
          <div class="btn-group">
            <button
              type="button"
              class="btn btn-sm btn-success"
              @click="() => go(`/actor/${actor.id}/edit`)"
            >
              <i class="fa-solid fa-pen"></i>
            </button>
            <button
              type="button"
              class="btn btn-sm btn-danger"
              @click="deleteActor(actor)"
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
