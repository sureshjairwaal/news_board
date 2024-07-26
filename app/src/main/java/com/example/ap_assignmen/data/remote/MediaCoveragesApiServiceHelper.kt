package com.example.ap_assignmen.data.remote

import com.example.ap_assignmen.ui.home.models.ModelNewsArticles
import kotlinx.coroutines.flow.Flow

interface MediaCoveragesApiServiceHelper {
    fun getMediaCoverages(query: String, apiKey: String): Flow<ModelNewsArticles>
}