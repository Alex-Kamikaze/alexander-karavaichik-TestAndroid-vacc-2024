package com.alexkarav.testandroidvacc24.data.remote.models.user


import com.google.gson.annotations.SerializedName

data class UserLoginResponse(
    @SerializedName("token")
    val token: String
)