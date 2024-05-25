package com.alexkarav.testandroidvacc24.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexkarav.testandroidvacc24.data.remote.models.products.ProductList
import com.alexkarav.testandroidvacc24.domain.repo.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopListViewModel @Inject constructor(private val productRepositoryImpl: ProductRepositoryImpl): ViewModel() {

    private val _productList = MutableStateFlow(ProductList())
    val productList = _productList.asStateFlow()

    init {
        println("Shoplist model initialized")
        updateProductList()
    }

    fun updateProductList() {
        viewModelScope.launch {
            val result = productRepositoryImpl.getAllProductsFromRemote()
            if(result.isSuccess) {
                println("Product list retrieved successfully")
                _productList.value = result.getOrNull()!!
            }
            else {
                println(result.exceptionOrNull()!!.message)
            }
        }
    }

}