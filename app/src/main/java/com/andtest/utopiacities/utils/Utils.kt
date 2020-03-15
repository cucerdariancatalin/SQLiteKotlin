package com.andtest.utopiacities.utils

import com.andtest.utopiacities.db.Database
import com.andtest.utopiacities.repository.CityRepository
import com.andtest.utopiacities.viewmodel.CityViewModelFactory

object Utils {
    fun provideViewModelFactory() : CityViewModelFactory {
        var repository = CityRepository.getInstance(Database.getInstance().cityDao)
        return CityViewModelFactory(repository)
    }
}