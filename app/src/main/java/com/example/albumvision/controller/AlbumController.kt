package com.example.albumvision.controller

import com.example.albumvision.model.Album
import com.example.albumvision.service.AlbumApiService
import com.example.albumvision.view.AlbumView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumController(
    private val albumApiService: AlbumApiService,
    private val view: AlbumView
) {
    fun getAlbums(userId: Int) {
        albumApiService.getAlbums(userId).enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                if (response.isSuccessful) {
                    val albums = response.body()
                    albums?.let { view.displayAlbums(it) }
                } else {
                    view.displayError("Falha ao buscar álbuns")
                }
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                view.displayError("Erro: ${t.message}")
            }
        })
    }
}