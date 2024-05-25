package com.alexkarav.testandroidvacc24.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexkarav.testandroidvacc24.domain.mappers.RemoteProductListToListItem
import com.alexkarav.testandroidvacc24.domain.models.ProductListItemModel
import com.alexkarav.testandroidvacc24.domain.repo.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(private val productRepository: ProductRepositoryImpl): ViewModel() {
    private val _productDetails = MutableStateFlow(ProductListItemModel("", 0, "", "", "", 0.0, 0.0))
    val productDetails = _productDetails.asStateFlow()

    fun loadProductDetails(id: Int) {
        viewModelScope.launch {
            val result = productRepository.getProductFromRemoteById(id)
            if(result.isSuccess) {
                _productDetails.value = RemoteProductListToListItem.singleRemoteItemIntoProductModel(result.getOrNull()!!)
            }
            else {
                println(result.exceptionOrNull()?.message)
            }
        }
    }
}