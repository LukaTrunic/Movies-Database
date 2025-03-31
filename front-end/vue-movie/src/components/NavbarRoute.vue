<script setup lang="ts">
import { RouterLink } from "vue-router";

export interface NavbarRouteProps {
  to: string;
  name: string;
}

const { to, name } = defineProps<NavbarRouteProps>();
</script>

<template>
  <li class="nav-item">
    <RouterLink class="nav-link" :to="to">
      {{ name }}
    </RouterLink>
  </li>
</template>
