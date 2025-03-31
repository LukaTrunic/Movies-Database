<script setup lang="ts">
import NavbarRoute from './components/NavbarRoute.vue';
import { ref } from 'vue';

const year = new Date().getFullYear();
const isDarkMode = ref(true);

const toggleTheme = () => {
  isDarkMode.value = !isDarkMode.value;
  document.documentElement.setAttribute('data-bs-theme', isDarkMode.value ? 'dark' : 'light');
};
</script>

<template>
  <nav class="navbar navbar-expand-lg">
    <div class="container">
      <RouterLink class="navbar-brand" to="/">
        <i class="fa-solid fa-film"></i> ITWS
      </RouterLink>
      <button @click="toggleTheme" class="btn btn-primary">
        <i v-if="isDarkMode" class="fas fa-sun"></i>
        <i v-else class="fas fa-moon"></i>
        Toggle Dark Mode
      </button>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <NavbarRoute to="/" name="Home" />
          <NavbarRoute to="/movie" name="Movies" />
          <NavbarRoute to="/actor" name="Actors" />
        </ul>
      </div>
    </div>
  </nav>
  <div class="container">
    <RouterView />
    <footer class="text-center fw-bold">
      &copy; {{ year }} Luka Trunic - 2021230020
    </footer>
  </div>
</template>
