package com.andtest.utopiacities.model

import android.os.Parcel
import android.os.Parcelable

data class CityModel(val id: String?, val country: String?, val city: String?, val population: Int?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    constructor(id: String, country: String, city: String, population: Int) : this(id, country, city, null)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(country)
        parcel.writeString(city)
        parcel.writeValue(population)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CityModel> {
        override fun createFromParcel(parcel: Parcel): CityModel {
            return CityModel(parcel)
        }

        override fun newArray(size: Int): Array<CityModel?> {
            return arrayOfNulls(size)
        }
    }
}