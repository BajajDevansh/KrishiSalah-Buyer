package com.codesmiths.krishisalah_buyer.apiCalling

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val tokenManager: TokenManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // Skip adding tokens for login & refresh endpoints
        val path = request.url.encodedPath
        if (path.contains("login") || path.contains("register")) {
            return chain.proceed(request)
        }
        val requestBuilder=chain.request().newBuilder()
        tokenManager.getAccessToken()?.let{
            requestBuilder.addHeader("Authorization","Bearer $it")
        }
        tokenManager.getRefreshToken()?.let{
            requestBuilder.addHeader("Refresh-Token",it)
        }
        return chain.proceed(requestBuilder.build())
    }

}