package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ViewModel : ViewModel() {
    private val shoesListing = mutableListOf(
        Shoe("Nike One", "42", "Nike", "220", "Testing"),
        Shoe("Nike Go", "44", "Nike", "120", "Testing"),
        Shoe("Adidas air", "41", "Adidas", "230", "Testing"),
        Shoe("Adidas Go", "45", "Adidas", "430", "Testing"),
    )
    private val colors = mutableListOf(
        "#F5F1FF",
    "#EBF6FF",
    "#EFFFED",
    "#FFF7F1",
    )
    private val imgs = mutableListOf<Int>(
        R.drawable.shoes1,
        R.drawable.shoes2,
        R.drawable.shoes3,
        R.drawable.shoes4
    )

    fun getRandomColor(): String {
        return colors.random()
    }

    fun getImage(index: Int): Int {
        return imgs[index % imgs.size]
    }

    fun addNewShoe(it: Shoe) {
        shoesListing.add(it)
        _shoesList.value = shoesListing
    }

    private val _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>> = _shoesList

    init {
        _shoesList.value = shoesListing
    }

}