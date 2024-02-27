package com.example.albumvision.controller

import com.example.albumvision.model.Photo
import com.example.albumvision.service.PhotoApiService
import com.example.albumvision.view.PhotoView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoController(
    private val photoApiService: PhotoApiService,
    private val view: PhotoView
) {
    fun getPhotos(albumId: Int) {
        photoApiService.getPhotos(albumId).enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    val photos = response.body()
                    photos?.let { view.displayPhotos(it) }
                } else {
                    view.displayError("Falha ao buscar foto")
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                view.displayError("Erro: ${t.message}")
            }
        })
    }
}