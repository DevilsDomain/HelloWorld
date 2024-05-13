package com.harbourspace.unsplash.model.cb

import com.harbourspace.unsplash.photoData.UnsplashPhotoDetails

interface UnsplashPhotoResult {

    fun onDataFetchedSuccess(photoDetails: List<UnsplashPhotoDetails>)

    fun onDataFetchedFailed()
}
