package com.example.ap_assignmen.ui.home.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ap_assignmen.BuildConfig
import com.example.ap_assignmen.repository.MediaCoveragesRepositoryImpl
import com.example.ap_assignmen.ui.home.models.ModelNewsArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MediaCoverageViewModel: ViewModel() {
    val TAG = this.javaClass.canonicalName
    val repository: MediaCoveragesRepositoryImpl = MediaCoveragesRepositoryImpl()

    var mediaCoveragesList: MutableLiveData<ArrayList<ModelNewsArticles.Article>> = MutableLiveData()

    fun initData(){
        viewModelScope.launch {
            repository.getMediaCoverages( "india", BuildConfig.API_KEY)
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.d(TAG, "${it.localizedMessage}")
                }
                .collectLatest {
                    mediaCoveragesList.postValue(it.articles as ArrayList<ModelNewsArticles.Article>?)
                }
        }
    }
}