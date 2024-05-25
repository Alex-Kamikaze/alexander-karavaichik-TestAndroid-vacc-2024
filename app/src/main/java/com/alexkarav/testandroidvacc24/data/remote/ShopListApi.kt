package com.alexkarav.testandroidvacc24.data.remote

import com.alexkarav.testandroidvacc24.data.remote.models.products.ProductList
import com.alexkarav.testandroidvacc24.data.remote.models.products.ProductListItem
import com.alexkarav.testandroidvacc24.data.remote.models.user.NewUserRemoteModel
import com.alexkarav.testandroidvacc24.data.remote.models.user.UserLoginInfoRequest
import com.alexkarav.testandroidvacc24.data.remote.models.user.UserLoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ShopListApi {

    @POST("/users")
    suspend fun addNewUser(@Body newUser: NewUserRemoteModel)

    @POST("/auth/login")
    suspend fun loginUser(@Body userLoginInfoRequest: UserLoginInfoRequest): UserLoginResponse

    @GET("/products")
    suspend fun getAllProducts(): ProductList

    @GET("/products/{id}")
    suspend fun getProductById(@Path("id") id: Int): ProductListItem

    companion object {
        const val BASE_URL = "https://fakestoreapi.com"
    }
}