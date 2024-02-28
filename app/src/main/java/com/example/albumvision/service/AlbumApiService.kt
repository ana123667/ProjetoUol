package com.example.albumvision.service

import com.example.albumvision.model.Album
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumApiService {
    @GET("/albums/{userId}")
    fun getAlbums(@Path("userId") userId: Int): Call<List<Album>>
}