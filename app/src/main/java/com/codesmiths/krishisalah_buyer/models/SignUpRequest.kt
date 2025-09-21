package com.codesmiths.KrishiSalah.models

data class SignUpRequest(
    val name: String,
    val phone: String,
    val password: String,
    val village: String,
    val district: String,
    val state: String,
    val pincode: String
)
