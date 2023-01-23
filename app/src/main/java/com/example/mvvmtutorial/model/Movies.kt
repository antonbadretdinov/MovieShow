package com.example.mvvmtutorial.model

data class Movies(
    val movies: List<Movie>
)

data class Movie(
    val movie: String,
    val year: Int,
    val rating: Double,
    val duration: String,
    val director: String,
    val tagline: String,
    val image: String
)
