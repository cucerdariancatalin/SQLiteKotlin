package com.andtest.utopiacities.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andtest.utopiacities.repository.CityRepository

class CityViewModelFactory(private val CityRepository: CityRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CityViewModel(CityRepository) as T
    }
}