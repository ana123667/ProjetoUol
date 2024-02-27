package com.example.albumvision.view

import com.example.albumvision.model.Photo

interface PhotoView {
    fun displayPhotos(photos: List<Photo>)
    fun displayError(message: String)
}