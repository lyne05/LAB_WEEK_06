package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        // Glide is used here to load the images
        // Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this),
            object : CatAdapter.OnClickListener {
                // When this is triggered, the pop up dialog will be shown
                override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup the adapter on the recycler view
        recyclerView.adapter = catAdapter

        // Setup the layout manager for the recycler view
        // A layout manager is used to manage the structuring of the item views
        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )

        //Instantiate ItemTouchHelper for the swipe to delete callback and
        //attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Add data to the model (list in the adapter)
        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Missy", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.MaineCoon, "Leo", "The gentle giant", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Female, CatBreed.Siamese, "Luna", "Elegant night hunter", "https://cdn2.thecatapi.com/images/ai6.jpg"),
                CatModel(Gender.Male, CatBreed.Bengal, "Max", "Playful and curious", "https://cdn2.thecatapi.com/images/O3btzLlsO.png"),
                CatModel(Gender.Unknown, CatBreed.Siberian, "Snow", "Loves the cold", "https://cdn2.thecatapi.com/images/3bk.jpg"),
                CatModel(Gender.Female, CatBreed.Persian, "Misty", "Fluffy and calm", "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"),
                CatModel(Gender.Male, CatBreed.Abyssinian, "Simba", "Always curious", "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"),
                CatModel(Gender.Female, CatBreed.BritishShorthair, "Chloe", "Quiet and classy", "https://cdn2.thecatapi.com/images/cqZqXgE8r.jpg")
            )
        )
    }

    // This will create a pop up dialog when one of the items from the recycler view is clicked.
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            // Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")
            // Set if the button should be enabled
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
