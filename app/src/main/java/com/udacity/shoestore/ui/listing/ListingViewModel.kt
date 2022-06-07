package com.udacity.shoestore.ui.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListingViewModel : ViewModel() {
    private val shoesListing = listOf(
        Shoe("Nike One", 42, "Nike", "220", "Testing"),
        Shoe("Nike Go", 44, "Nike", "120", "Testing"),
        Shoe("Adidas air", 41, "Adidas", "230", "Testing"),
        Shoe("Adidas Go", 45, "Adidas", "430", "Testing"),
    )

    private val _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>> = _shoesList

    init {
        _shoesList.value = shoesListing
    }

}