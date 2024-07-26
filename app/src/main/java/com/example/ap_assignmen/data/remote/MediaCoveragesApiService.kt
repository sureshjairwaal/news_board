package com.example.ap_assignmen.data.remote

import com.example.ap_assignmen.ui.home.models.ModelNewsArticles
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaCoveragesApiService {
    @GET("everything")
    suspend fun getNewsArticles(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String): ModelNewsArticles
}