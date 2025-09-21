package com.codesmiths.krishisalah_buyer.models

data class Products(
    val location: Location,
    val _id: String,
    val farmer: String,
    val productName:String,
    val category: String,
    val description: String,
    val quantity: Int,
    val currentQuantity: Int,
    val unit: String,
    val pricePerUnit: Double,
    val images: List<String>,
    val availability: Boolean,
    val listedBy: String,
    val createdAt: String,
    val updatedAt: String,
    val __v: Int
)