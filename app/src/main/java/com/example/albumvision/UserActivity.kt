package com.example.albumvision

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.albumvision.adapters.UserAdapter
import com.example.albumvision.controller.UserController
import com.example.albumvision.model.User
import com.example.albumvision.network.RetrofitClient
import com.example.albumvision.service.UserApiService
import com.example.albumvision.view.UserView

class UserActivity : ComponentActivity(), UserView {

    private val userApiService = RetrofitClient.createService(UserApiService::class.java)
    private val userController = UserController(userApiService, this)
    private lateinit var userAdapter: UserAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter()

        userController.getUsers()
    }

    override fun displayUsers(users: List<User>) {
        userAdapter.setData(users)
    }

    override fun displayError(message: String) {
        Log.e(TAG, "Erro: $message")
        // Exibir uma mensagem de erro para o usuário
        Toast.makeText(this, "Erro: $message", Toast.LENGTH_SHORT).show()
    }
}