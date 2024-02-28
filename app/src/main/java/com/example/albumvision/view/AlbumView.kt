package com.example.albumvision.view

import com.example.albumvision.model.Album

interface AlbumView {
    fun displayAlbums(albums: List<Album>)
    fun displayError(message: String)
}