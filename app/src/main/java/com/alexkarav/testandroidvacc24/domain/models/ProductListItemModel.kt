package com.alexkarav.testandroidvacc24.domain.models

data class ProductListItemModel(
    val title: String,
    val id: Int,
    val image: String,
    val description: String,
    val category: String,
    val price: Double,
    val rating: Double
)
