package com.codesmiths.krishisalah_buyer.repository

import com.codesmiths.KrishiSalah.models.LoginRequest
import com.codesmiths.KrishiSalah.models.LoginResponse
import com.codesmiths.KrishiSalah.models.SignUpRequest
import com.codesmiths.krishisalah_buyer.apiCalling.ApiService
import com.codesmiths.krishisalah_buyer.apiCalling.TokenManager
import com.codesmiths.krishisalah_buyer.models.OrderRequest
import com.codesmiths.krishisalah_buyer.models.OrderResponse
import com.codesmiths.krishisalah_buyer.models.ProductId
import com.codesmiths.krishisalah_buyer.models.ProductListResponse
import com.codesmiths.krishisalah_buyer.models.SingleProduct

class BuyerRepository(
    private val apiService: ApiService,
    private val tokenManager: TokenManager
) {
    suspend fun login(loginRequest: LoginRequest): LoginResponse{
        val response = apiService.login(loginRequest)
        tokenManager.saveTokens(response.AccessToken,response.RefreshToken)
        return response
    }
    suspend fun register(signUpRequest: SignUpRequest): LoginResponse{
        val response = apiService.register(signUpRequest)
        tokenManager.saveTokens(response.AccessToken,response.RefreshToken)
        return response
    }
    suspend fun fetchProducts():ProductListResponse{
        return apiService.getProducts()
    }
    suspend fun getProductById(productId:ProductId):SingleProduct{
        return apiService.getProductById(productId)
    }
    suspend fun placeOrder(orderRequest: OrderRequest):OrderResponse{
        return apiService.placeOrder(orderRequest)
    }

}