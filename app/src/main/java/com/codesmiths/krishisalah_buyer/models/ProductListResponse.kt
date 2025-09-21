package com.codesmiths.krishisalah_buyer.models

data class ProductListResponse(
    val success: Boolean,
    val message: String,
    val AllProducts: List<Products>
)
