package com.example.albumvision

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.albumvision.adapters.AlbumAdapter
import com.example.albumvision.controller.AlbumController
import com.example.albumvision.model.Album
import com.example.albumvision.network.RetrofitClient
import com.example.albumvision.service.AlbumApiService
import com.example.albumvision.view.AlbumView
import kotlinx.coroutines.launch

class AlbumActivity : ComponentActivity(), AlbumView {

    private val albumApiService = RetrofitClient.createService(AlbumApiService::class.java)
    private val albumController = AlbumController(albumApiService, this)
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        val albumRecyclerView: RecyclerView = findViewById(R.id.albumRecyclerView)
        albumRecyclerView.layoutManager = LinearLayoutManager(this)
        albumAdapter = AlbumAdapter { album -> onAlbumClick(album) }
        albumRecyclerView.adapter = albumAdapter

        val userId = intent.getIntExtra(UserDetailsActivity.EXTRA_USER_ID, -1)
        if (userId != -1) {
            lifecycleScope.launch {
                albumController.getAlbums(userId)
            }
        }
    }

    override fun displayAlbums(albums: List<Album>) {
        albumAdapter.setData(albums)
    }

    override fun displayError(message: String) {
        Log.e(ContentValues.TAG, "Erro: $message")
        // Exibir uma mensagem de erro para o usuário usando um Toast
        Toast.makeText(this, "Erro: $message", Toast.LENGTH_SHORT).show()
    }

    private fun onAlbumClick(album: Album) {
        val intent = Intent(this, AlbumActivity::class.java)

        // Passe informações sobre o álbum selecionado
        intent.putExtra("albumId", album.id)
        intent.putExtra("albumTitle", album.title)

        // Inicie a atividade AlbumActivity
        startActivity(intent)
    }

    companion object {
        const val EXTRA_USER_ID = "extra_user_id"
    }
}