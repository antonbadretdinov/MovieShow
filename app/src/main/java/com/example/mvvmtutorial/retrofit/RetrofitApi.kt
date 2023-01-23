package com.example.mvvmtutorial.retrofit

import com.example.mvvmtutorial.api.MoviesApi
import com.example.mvvmtutorial.model.Movies
import retrofit2.http.GET

interface RetrofitApi: MoviesApi {

    @GET("/json/moviesData.json")
    override suspend fun getMovies(): Movies
}