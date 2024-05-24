package com.alexkarav.testandroidvacc24.data.remote

import com.alexkarav.testandroidvacc24.data.remote.models.NewUserRemoteModel
import com.alexkarav.testandroidvacc24.data.remote.models.UserLoginInfoRequest
import com.alexkarav.testandroidvacc24.data.remote.models.UserLoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ShopListApi {

    @POST("/users")
    suspend fun addNewUser(@Body newUser: NewUserRemoteModel)

    @POST("/auth/login")
    suspend fun loginUser(@Body userLoginInfoRequest: UserLoginInfoRequest): UserLoginResponse

    companion object {
        const val BASE_URL = "https://fakestoreapi.com"
    }
}