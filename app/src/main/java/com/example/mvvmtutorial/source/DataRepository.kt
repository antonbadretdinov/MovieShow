package com.example.mvvmtutorial.source

import com.example.mvvmtutorial.api.MoviesApi
import com.example.mvvmtutorial.model.Movies

class DataRepository(private val moviesApi: MoviesApi) {

    suspend fun getMovie(): Movies {
        return moviesApi.getMovies()
    }

}