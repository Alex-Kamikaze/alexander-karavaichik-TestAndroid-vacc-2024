package com.alexkarav.testandroidvacc24.domain.repo

import com.alexkarav.testandroidvacc24.data.remote.ShopListApi
import com.alexkarav.testandroidvacc24.data.remote.models.products.ProductList
import com.alexkarav.testandroidvacc24.data.remote.models.products.ProductListItem
import com.alexkarav.testandroidvacc24.data.repo.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val shopListApi: ShopListApi): ProductRepository {
    override suspend fun getAllProductsFromRemote(): Result<ProductList> {
        return try {
            Result.success(shopListApi.getAllProducts())
        }
        catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getProductFromRemoteById(id: Int): Result<ProductListItem> {
        return try  {
            Result.success(shopListApi.getProductById(id))
        }
        catch (e: Exception) {
            Result.failure(e)
        }
    }
}