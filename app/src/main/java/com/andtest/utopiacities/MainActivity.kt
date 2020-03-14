package com.andtest.utopiacities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andtest.utopiacities.adapter.CityAdapter
import com.andtest.utopiacities.utils.Utils
import com.andtest.utopiacities.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var cityRecyclerView: RecyclerView
    private lateinit var adapter: CityAdapter
    private lateinit var viewModel: CityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityRecyclerView = findViewById(R.id.rvCityList)

        val factory = Utils.provideViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, factory).get(CityViewModel::class.java)
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
        cityRecyclerView.adapter = adapter
        cityRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
