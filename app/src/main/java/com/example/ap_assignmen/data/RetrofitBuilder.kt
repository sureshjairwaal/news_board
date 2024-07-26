package com.example.ap_assignmen.data

import com.example.ap_assignmen.constants.Constants
import com.example.ap_assignmen.data.remote.MediaCoveragesApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    private const val BASE_URL = Constants.api_Url

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient().build())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)
        builder.connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
        return builder
    }

    val userApiService : MediaCoveragesApiService = getRetrofit().create(MediaCoveragesApiService::class.java)
}