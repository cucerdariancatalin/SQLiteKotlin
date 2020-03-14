package com.andtest.utopiacities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andtest.utopiacities.adapter.CityAdapter
import com.andtest.utopiacities.utils.Utils
import com.andtest.utopiacities.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var cityListView: ListView
    private lateinit var adapter: CityAdapter
    private lateinit var viewModel: CityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityListView = findViewById(R.id.rvCityList)

        val factory = Utils.provideViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(CityViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        loadCities()
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        viewModel.closeDatabase(this)
        super.onDestroy()
    }

    private fun loadCities() {
        val cities = viewModel.loadCities(this)
        adapter = CityAdapter(this, cities)
        cityListView.adapter = adapter
    }
}
