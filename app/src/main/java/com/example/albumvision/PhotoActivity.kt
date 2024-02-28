package com.example.albumvision

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.albumvision.adapters.PhotoAdapter
import com.example.albumvision.controller.PhotoController
import com.example.albumvision.model.Photo
import com.example.albumvision.network.RetrofitClient
import com.example.albumvision.service.PhotoApiService
import com.example.albumvision.view.PhotoView
import kotlinx.coroutines.launch

class PhotoActivity : ComponentActivity(), PhotoView {

    private val photoApiService = RetrofitClient.createService(PhotoApiService::class.java)
    private val photoController = PhotoController(photoApiService, this)
    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        val photoGridView: GridView = findViewById(R.id.photoGridView)
        photoAdapter = PhotoAdapter()
        photoGridView.adapter = photoAdapter

        val albumId = intent.getIntExtra(AlbumActivity.EXTRA_USER_ID, -1)
        if (albumId != -1) {
            lifecycleScope.launch {
                photoController.getPhotos(albumId)
            }
        }
    }

    override fun displayPhotos(photos: List<Photo>) {
        photoAdapter.setData(photos)
    }

    override fun displayError(message: String) {
        Log.e(ContentValues.TAG, "Erro: $message")
        // Exibir uma mensagem de erro para o usuário
        Toast.makeText(this, "Erro: $message", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRA_ALBUM_ID = "extra_album_id"
    }
}