package com.alexkarav.testandroidvacc24.data.repo

import com.alexkarav.testandroidvacc24.data.remote.models.products.ProductList
import com.alexkarav.testandroidvacc24.data.remote.models.products.ProductListItem

interface ProductRepository {

    suspend fun getAllProductsFromRemote(): Result<ProductList>

    suspend fun getProductFromRemoteById(id: Int): Result<ProductListItem>

}