package com.alexkarav.testandroidvacc24.data.remote.models


import com.alexkarav.testandroidvacc24.data.remote.models.Geolocation
import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("geolocation")
    val geolocation: Geolocation,
    @SerializedName("number")
    val number: Int, //Номер дома
    @SerializedName("street")
    val street: String,
    @SerializedName("zipcode")
    val zipcode: String
)