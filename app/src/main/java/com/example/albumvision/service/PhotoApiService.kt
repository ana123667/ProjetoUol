package com.example.albumvision.service

import com.example.albumvision.model.Photo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoApiService {
    @GET("/photos/{albumId}")
    fun getPhotos(@Path("albumId") albumId: Int): Call<List<Photo>>
}