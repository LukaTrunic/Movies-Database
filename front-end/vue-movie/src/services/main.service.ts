import axios from "axios";

// Creates a client instance for making HTTP requests to the backend API
export const client = axios.create({
    baseURL: 'http://localhost:8080/api', // Base URL
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    validateStatus: (status) => status == 200 || status == 204 // Which status is valid
})

// For handling movie and actor related API calls
export class MainService {
    // Fetch all movies from the API
    static async getAllMovies(){
        return await client.get('/movie')
    }

    // Fetch a specific movie by its ID from the API
    static async getMovieById(id: number){
        return await client.get('/movie/'+id)
    }

    // Save a new movie to the API
    static async saveMovie(obj: any){
        return await client.request({
            url: '/movie',
            method: 'post',
            data: obj
        })
    }

    // Update an existing movie in the API
    static async updateMovie(id :number, obj: any){
        return await client.request({
      url: `/movie/${id}`,
      method: "put",
      data: obj
    })
    }

    // Delete a movie from the API
    static async deleteMovie(id :number){
        return await client.request({
            url: `/movie/${id}`,
            method: "delete"
        })
    }

    // Fetch all actors from the API
    static async getAllActors(){
        return await client.get('/actor')
    }

    // Fetch a specific actor by its ID from the API
    static async getActorById(id: number){
        return await client.get('/actor/'+id)
    }

    // Save a new actor to the API
    static async saveActor(obj: any){
        return await client.request({
            url: '/actor',
            method: 'post',
            data: obj
        })
    }

    // Update an existing actor in the API
    static async updateActor(id :number, obj: any){
        return await client.request({
      url: `/actor/${id}`,
      method: "put",
      data: obj
    })
    }

    // Delete an actor from the API
    static async deleteActor(id :number){
        return await client.request({
            url: `/actor/${id}`,
            method: "delete"
        })
    }
}