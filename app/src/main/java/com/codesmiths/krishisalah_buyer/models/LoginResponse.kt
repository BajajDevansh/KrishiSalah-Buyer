package com.codesmiths.KrishiSalah.models


data class LoginResponse(
    val success: Boolean,
    val message: String,
    val AccessToken:String,
    val RefreshToken:String,
    val _id:String
)
