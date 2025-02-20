package com.example.beeradviser

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var categoriesSpinner: Spinner
    private lateinit var showBreedsButton: Button
    private lateinit var breedsRecyclerView: RecyclerView

    private val categories = listOf("Pastores", "Pinscher", "Terrier", "Sabuesos", "Deportivos", "No deportivos", "Toy", "De trabajo")
    private val breedsMap = mapOf(
        "Pastores" to listOf("Pastor Catalán", "Pastor Alemán", "Komondor", "Pastor Australiano", "Pastor Belga", "Pastor de Shetland"),
        "Pinscher" to listOf("Dobermann", "Pinscher Alemán", "Pinscher Miniatura", "Schnauzer"),
        "Terrier" to listOf("Yorkshire Terrier", "Bull Terrier", "Jack Russell Terrier", "Airedale Terrier", "West Highland White Terrier"),
        "Sabuesos" to listOf("Beagle", "Dachshund", "Bloodhound", "Basset Hound", "Greyhound"),
        "Deportivos" to listOf("Labrador Retriever", "Golden Retriever", "Cocker Spaniel", "Pointer", "Setter Irlandés"),
        "No deportivos" to listOf("Bulldog", "Poodle", "Chow Chow", "Dalmatian", "Shiba Inu"),
        "Toy" to listOf("Chihuahua", "Pomeranian", "Pug", "Shih Tzu", "Maltés"),
        "De trabajo" to listOf("San Bernardo", "Boxer", "Rottweiler", "Dogo Argentino", "Gran Danés")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoriesSpinner = findViewById(R.id.categoriesSpinner)
        showBreedsButton = findViewById(R.id.showBreedsButton)
        breedsRecyclerView = findViewById(R.id.breedsRecyclerView)

        // Configurar el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categoriesSpinner.adapter = adapter

        // Configurar el RecyclerView
        breedsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Manejar el clic del botón
        showBreedsButton.setOnClickListener {
            val selectedCategory = categoriesSpinner.selectedItem as String
            val breeds = breedsMap[selectedCategory] ?: listOf()
            breedsRecyclerView.adapter = BreedAdapter(breeds)
        }
    }
}