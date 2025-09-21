package com.codesmiths.krishisalah_buyer.models

data class OrderRequest(
    val productId: String,
    val quantity: Int,
    val price: Double
)
data class OrderResponse(
    val success: Boolean,
    val message: String,
    val order:Order
)
data class Order(
    val Product:String,
    val OrderBy:String,
    val quantity: Int,
    val price: Double,
    val createdAt: String,
    val updatedAt: String,
    val __v: Int
)