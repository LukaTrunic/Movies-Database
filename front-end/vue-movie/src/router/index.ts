import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MovieView from '@/views/movie/MovieView.vue'
import EditMovie from '@/views/movie/EditMovie.vue'
import NewMovie from '@/views/movie/NewMovie.vue'
import ActorView from '@/views/actor/ActorView.vue'
import EditActor from '@/views/actor/EditActor.vue'
import NewActor from '@/views/actor/NewActor.vue'

const router = createRouter({
  history: createWebHistory('/'),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/movie',
      name: 'movie',
      component: MovieView
    },
    {
      path: '/movie/new',
      name: 'new-movie',
      component: NewMovie
    },
    {
      path: '/movie/:id/edit',
      name: 'edit-movie',
      component: EditMovie
    },
    {
      path: '/actor',
      name: 'actor',
      component: ActorView
    },
    {
      path: '/actor/new',
      name: 'new-actor',
      component: NewActor
    },
    {
      path: '/actor/:id/edit',
      name: 'edit-actor',
      component: EditActor
    }
  ]
})

export default router
