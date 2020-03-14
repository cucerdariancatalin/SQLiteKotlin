package com.andtest.utopiacities.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.andtest.utopiacities.model.CityModel
import com.andtest.utopiacities.repository.CityRepository

class CityViewModel(private val cityRepository: CityRepository): ViewModel() {
    fun loadCities(context: Context): ArrayList<CityModel> =
        cityRepository.loadCities(context)

    fun closeDatabase(context: Context) = cityRepository.closeDatabase(context)
}