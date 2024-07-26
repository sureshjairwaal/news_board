package com.example.ap_assignmen.repository

import com.example.ap_assignmen.ui.home.models.ModelNewsArticles
import kotlinx.coroutines.flow.Flow

interface MediaCoverageRepository {
    suspend fun getMediaCoverages(query: String, apiKey: String): Flow<ModelNewsArticles>
}