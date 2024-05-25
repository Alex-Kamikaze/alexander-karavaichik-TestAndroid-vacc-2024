package com.alexkarav.testandroidvacc24.data.remote.models.user


import com.google.gson.annotations.SerializedName

data class Geolocation(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("long")
    val long: String
)