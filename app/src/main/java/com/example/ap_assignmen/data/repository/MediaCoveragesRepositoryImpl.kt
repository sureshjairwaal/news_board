package com.example.ap_assignmen.repository

import com.example.ap_assignmen.data.RetrofitBuilder
import com.example.ap_assignmen.data.remote.MediaCoveragesApiServiceHelperImpl
import com.example.ap_assignmen.ui.home.models.ModelNewsArticles
import kotlinx.coroutines.flow.Flow

class MediaCoveragesRepositoryImpl : MediaCoverageRepository{
    private val apiService: MediaCoveragesApiServiceHelperImpl = MediaCoveragesApiServiceHelperImpl(
        RetrofitBuilder.userApiService
    )

    override suspend fun getMediaCoverages(query: String, apiKey: String): Flow<ModelNewsArticles> = apiService.getMediaCoverages(query, apiKey)
}