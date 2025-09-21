package com.codesmiths.krishisalah_buyer.apiCalling

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class TokenManager private constructor(context: Context){
    companion object{
        private const val PREF_NAME="app_prefs"
        private const val KEY_ACCESS="access_token"
        private const val KEY_REFRESH="refresh_token"
        @Volatile
        private var instance:TokenManager?=null
        fun getInstance(context: Context):TokenManager{
            return instance?: synchronized(this){
                instance?:TokenManager(context).also { instance=it }
            }
        }
    }
    private val sharedPreferences= EncryptedSharedPreferences.create(
        context,
        PREF_NAME,
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    fun saveTokens(
        access:String,refresh: String
    ){
        sharedPreferences.edit().apply{
            putString(KEY_ACCESS,access)
            putString(KEY_REFRESH,refresh)
            apply()
        }
    }
    fun getAccessToken(): String?=sharedPreferences.getString(KEY_ACCESS,null)
    fun getRefreshToken(): String?=sharedPreferences.getString(KEY_REFRESH,null)
    fun clearToken(){
        sharedPreferences.edit().clear().apply()
    }
}