package com.codesmiths.krishisalah_buyer.apiCalling

import com.codesmiths.KrishiSalah.models.LoginRequest
import com.codesmiths.KrishiSalah.models.LoginResponse
import com.codesmiths.KrishiSalah.models.SignUpRequest
import com.codesmiths.krishisalah_buyer.models.OrderRequest
import com.codesmiths.krishisalah_buyer.models.OrderResponse
import com.codesmiths.krishisalah_buyer.models.ProductId
import com.codesmiths.krishisalah_buyer.models.ProductListResponse
import com.codesmiths.krishisalah_buyer.models.SingleProduct
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("buyer/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST("buyer/register")
    suspend fun register(@Body registerRequest: SignUpRequest): LoginResponse

    @GET("buyer/fetchProducts")
    suspend fun getProducts(): ProductListResponse

    @POST("buyer/getProduct")
    suspend fun getProductById(@Body productId: ProductId):SingleProduct

    @POST("buyer/order")
    suspend fun placeOrder(@Body orderRequest: OrderRequest): OrderResponse
}