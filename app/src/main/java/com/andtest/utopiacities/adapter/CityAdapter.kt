package com.andtest.utopiacities.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andtest.utopiacities.R
import com.andtest.utopiacities.model.CityModel

class CityAdapter(private val context: Context, private val cities: ArrayList<CityModel>?):
    RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var city = itemView.findViewById<TextView>(R.id.tv_city)!!
        var country = itemView.findViewById<TextView>(R.id.tv_country)!!
        var population = itemView.findViewById<TextView>(R.id.tv_population)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cities?.size as Int
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cities?.get(position)
        holder.city.text = city?.city
        holder.country.text = city?.country
        holder.population.text = city?.population.toString()

        holder.itemView.setOnClickListener {
            //TODO: implement event click on item
        }
    }
}