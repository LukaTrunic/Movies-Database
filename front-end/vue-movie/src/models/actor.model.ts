import type { MovieModel } from "./movie.model"

export interface ActorModel {
    id: number
    fullName: string
    movies: MovieModel[]
    createdAt: string
    updatedAt: string | null
}