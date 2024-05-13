package com.harbourspace.unsplash.api

import com.harbourspace.unsplash.model.SearchResult
import com.harbourspace.unsplash.model.UnsplashItem
import com.harbourspace.unsplash.photoData.UnsplashPhotoDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

private const val AUTHORIZATION_CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "HpK_Qq3SKoyEhYR3_gV8JAZUXPebZAlLo88Hij2iYRg"

interface UnsplashApi {

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("photos")
    fun fetchPhotos() : Call<List<UnsplashItem>>

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("search/photos")
    fun searchPhotos(@Query(value = "query") keyword : String): Call<SearchResult>

    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("photos/{id}") // Define the endpoint with path parameter {id}
    fun fetchPhotoDetails(@Path("id") photoId: String): Call<UnsplashPhotoDetails>
}