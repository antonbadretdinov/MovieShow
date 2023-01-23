package com.example.mvvmtutorial.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmtutorial.model.Movie
import com.example.mvvmtutorial.retrofit.RetrofitInstance
import com.example.mvvmtutorial.source.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MainViewModel: ViewModel() {

    private val dataRepository = DataRepository(RetrofitInstance.service)

    val movieLiveData = MutableLiveData<Movie>()

    fun fetchMovie(){
        viewModelScope.launch {
            val movie = withContext(Dispatchers.IO){
                dataRepository.getMovie()
            }
            movieLiveData.value = movie.movies[Random.nextInt(9)]
        }
    }
}