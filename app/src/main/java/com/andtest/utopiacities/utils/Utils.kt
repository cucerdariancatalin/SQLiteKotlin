package com.andtest.utopiacities.utils

import android.content.Context
import com.andtest.utopiacities.db.Database
import com.andtest.utopiacities.repository.CityRepository
import com.andtest.utopiacities.viewmodel.CityViewModelFactory

object Utils {
    fun provideViewModelFactory(context: Context) : CityViewModelFactory {
        var repository = CityRepository.getInstance(Database.getInstance().cityDao)
        return CityViewModelFactory(repository)
    }
}