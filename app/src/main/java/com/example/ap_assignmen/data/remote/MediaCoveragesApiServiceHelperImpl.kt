package com.example.ap_assignmen.data.remote

import kotlinx.coroutines.flow.flow

class MediaCoveragesApiServiceHelperImpl(private val apiService: MediaCoveragesApiService): MediaCoveragesApiServiceHelper {
    override fun getMediaCoverages(query: String, apiKey: String) = flow {
        emit(apiService.getNewsArticles(query, apiKey))
    }
}