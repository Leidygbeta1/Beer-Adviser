package com.example.beeradviser

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var categoriesRecyclerView: RecyclerView
    private lateinit var breedsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView)
        breedsRecyclerView = findViewById(R.id.breedsRecyclerView)

        val categories = listOf(
            "Pastores",
            "Pinscher",
            "Terrier",
            "Sabuesos",
            "Deportivos",
            "No deportivos",
            "Toy",
            "De trabajo"
        )

        val breedsMap = mapOf(
            "Pastores" to listOf("Pastor Catalán", "Pastor Alemán", "Komondor", "Pastor Australiano", "Pastor Belga", "Pastor de Shetland"),
            "Pinscher" to listOf("Dobermann", "Pinscher Alemán", "Pinscher Miniatura", "Schnauzer"),
            "Terrier" to listOf("Yorkshire Terrier", "Bull Terrier", "Jack Russell Terrier", "Airedale Terrier", "West Highland White Terrier"),
            "Sabuesos" to listOf("Beagle", "Dachshund", "Bloodhound", "Basset Hound", "Greyhound"),
            "Deportivos" to listOf("Labrador Retriever", "Golden Retriever", "Cocker Spaniel", "Pointer", "Setter Irlandés"),
            "No deportivos" to listOf("Bulldog", "Poodle", "Chow Chow", "Dalmatian", "Shiba Inu"),
            "Toy" to listOf("Chihuahua", "Pomeranian", "Pug", "Shih Tzu", "Maltés"),
            "De trabajo" to listOf("San Bernardo", "Boxer", "Rottweiler", "Dogo Argentino", "Gran Danés")
        )

        val categoriesAdapter = CategoryAdapter(categories) { selectedCategory ->
            val breeds = breedsMap[selectedCategory] ?: listOf()
            breedsRecyclerView.adapter = BreedAdapter(breeds)
        }

        categoriesRecyclerView.layoutManager = LinearLayoutManager(this)
        breedsRecyclerView.layoutManager = LinearLayoutManager(this)

        categoriesRecyclerView.adapter = categoriesAdapter
    }
}