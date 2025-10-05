package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        // Glide digunakan sebagai ImageLoader
        CatAdapter(layoutInflater, GlideImageLoader(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup adapter untuk RecyclerView
        recyclerView.adapter = catAdapter

        // Setup layout manager (vertikal)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Tambah data dummy ke adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    name = "Fred",
                    breed = CatBreed.BalineseJavanese,
                    biography = "Silent and deadly",
                    gender = Gender.Male,
                    imageUrl = "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    name = "Wilma",
                    breed = CatBreed.ExoticShorthair,
                    biography = "Cuddly assassin",
                    gender = Gender.Female,
                    imageUrl = "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    name = "Curious George",
                    breed = CatBreed.AmericanCurl,
                    biography = "Award winning investigator",
                    gender = Gender.Unknown,
                    imageUrl = "https://cdn2.thecatapi.com/images/bar.jpg"
                )
            )
        )
    }
}
