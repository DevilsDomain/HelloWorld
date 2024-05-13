package com.harbourspace.unsplash.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harbourspace.unsplash.api.UnsplashApiProvider
import com.harbourspace.unsplash.model.cb.UnsplashPhotoResult
import com.harbourspace.unsplash.photoData.UnsplashPhotoDetails


class DetailsViewModel : ViewModel(), UnsplashPhotoResult {

    private val _photoDetails = MutableLiveData<UnsplashPhotoDetails>()
    val photoDetails: LiveData<UnsplashPhotoDetails> = _photoDetails

    private val unsplashApiProvider by lazy {
        UnsplashApiProvider()
    }

    fun fetchPhotoDetails(photoId: String) {
        unsplashApiProvider.fetchPhotoDetails(photoId, this)
    }

    override fun onDataFetchedSuccess(photoDetails: List<UnsplashPhotoDetails>) {
        if (photoDetails.isNotEmpty()) {
            _photoDetails.value = photoDetails[0]
        } else {
            Log.d("DetailsViewModel", "Empty response")
        }
    }

    override fun onDataFetchedFailed() {
        Log.e("DetailsViewModel", "Data fetching failed")
    }
}
