package com.example.mvvmtutorial

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mvvmtutorial.databinding.ActivityMainBinding
import com.example.mvvmtutorial.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    //View binding
    private lateinit var binding: ActivityMainBinding

    //View model
    private lateinit var viewModel: MainViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.movieLiveData.observe(this) {
            binding.tvName.text = "Name: ${it.movie}"
            binding.tvDirector.text = "Director: ${it.director}"
            binding.tvDuration.text = "Duration: ${it.duration}"
            binding.tvYear.text = "Year: ${it.year}"
            binding.tvRating.text = "Rating: ${it.rating}"
            binding.tvTagline.text = "Tagline: ${it.tagline}"
            Glide.with(this).load(it.image).into(binding.imageView)
        }
        viewModel.fetchMovie()
    }
}