package com.alexkarav.testandroidvacc24.data.remote.models.user


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String
)