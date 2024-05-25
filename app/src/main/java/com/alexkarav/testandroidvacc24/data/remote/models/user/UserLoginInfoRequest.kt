package com.alexkarav.testandroidvacc24.data.remote.models.user


import com.google.gson.annotations.SerializedName

data class UserLoginInfoRequest(
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)