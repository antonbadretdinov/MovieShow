package com.example.mvvmtutorial.api

import com.example.mvvmtutorial.model.Movies

interface MoviesApi {
    suspend fun getMovies(): Movies
}