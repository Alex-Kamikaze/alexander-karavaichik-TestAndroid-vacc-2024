package com.alexkarav.testandroidvacc24.domain.mappers

import com.alexkarav.testandroidvacc24.data.remote.models.products.ProductList
import com.alexkarav.testandroidvacc24.data.remote.models.products.ProductListItem
import com.alexkarav.testandroidvacc24.domain.models.ProductListItemModel

object RemoteProductListToListItem {
    fun intoListItem(productList: ProductList): List<ProductListItemModel> {
        val result = mutableListOf<ProductListItemModel>()
        productList.forEach {productListItem ->
            result.add(ProductListItemModel(
                category = productListItem.category,
                price = productListItem.price,
                title = productListItem.title,
                id = productListItem.id,
                rating = productListItem.rating.rate,
                image = productListItem.image,
                description = productListItem.description
            ))
        }
        return result
    }

    fun singleRemoteItemIntoProductModel(productListItem: ProductListItem): ProductListItemModel {
        return ProductListItemModel(
            category = productListItem.category,
            price = productListItem.price,
            title = productListItem.title,
            id = productListItem.id,
            rating = productListItem.rating.rate,
            image = productListItem.image,
            description = productListItem.description
        )
    }
}