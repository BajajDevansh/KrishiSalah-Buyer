package com.codesmiths.krishisalah_buyer.viewModels

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codesmiths.KrishiSalah.models.LoginRequest
import com.codesmiths.KrishiSalah.models.LoginResponse
import com.codesmiths.KrishiSalah.models.SignUpRequest
import com.codesmiths.krishisalah_buyer.apiCalling.ApiClient
import com.codesmiths.krishisalah_buyer.apiCalling.TokenManager
import com.codesmiths.krishisalah_buyer.models.OrderRequest
import com.codesmiths.krishisalah_buyer.models.OrderResponse
import com.codesmiths.krishisalah_buyer.models.ProductId
import com.codesmiths.krishisalah_buyer.models.ProductListResponse
import com.codesmiths.krishisalah_buyer.models.Products
import com.codesmiths.krishisalah_buyer.models.SingleProduct
import com.codesmiths.krishisalah_buyer.repository.BuyerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BuyerViewModel(context: Context): ViewModel() {
    private val tokenManager = TokenManager.getInstance(context)
    private val apiService= ApiClient.create(context)
    private val repository= BuyerRepository(apiService,tokenManager)

    private val _loginState= MutableStateFlow<Result<Boolean>>(Result.success(false))
    val loginState=_loginState.asStateFlow()

    private val _signUpState= MutableStateFlow<Result<Boolean>>(Result.success(false))
    val signUpState=_signUpState.asStateFlow()

    private val _productsList= MutableStateFlow<List<Products>>(emptyList())
    val productsList=_productsList.asStateFlow()

    private val _productDetails= MutableStateFlow<SingleProduct?>(null)
    val productDetails=_productDetails.asStateFlow()

    private val _orderState= MutableStateFlow<Result<Boolean>>(Result.success(false))
    val orderState=_orderState.asStateFlow()

    fun login(loginRequest: LoginRequest){
        var response: LoginResponse
        viewModelScope.launch {
            response=repository.login(loginRequest)
            if(response.success){
                _loginState.value=Result.success(true)
            }else{
                _loginState.value=Result.failure(Exception(response.message))
            }
        }
    }
    init {
        if (loginState.value.isSuccess) fetchProducts()
    }
    fun signUp(signUpRequest: SignUpRequest){
        var response: LoginResponse
        viewModelScope.launch {
            response=repository.register(signUpRequest)
            if(response.success){
                _signUpState.value=Result.success(true)
            }else {
                _signUpState.value = Result.failure(Exception(response.message))
            }
        }
    }
    fun fetchProducts(){
        var response: ProductListResponse
        viewModelScope.launch {
            try{
                response = repository.fetchProducts()
                _productsList.value = response.AllProducts
            }catch (e: Exception){
                Log.e("BuyerViewModel","Error fetching products: ${e.message}")
            }
        }
    }

    fun fetchProductById(productId: ProductId){
        var response: SingleProduct
        viewModelScope.launch {
            response=repository.getProductById(productId)
            _productDetails.value=response
        }
    }
    fun placeOrder(order: OrderRequest){
        var response: OrderResponse
        viewModelScope.launch {

            response=repository.placeOrder(order)
            if(response.success){
                _orderState.value=Result.success(true)
            }else{
                _orderState.value=Result.failure(Exception(response.message))
            }
        }
    }
}