package com.example.albumvision.controller

import com.example.albumvision.model.User
import com.example.albumvision.service.UserApiService
import com.example.albumvision.view.UserView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserController(
    private val userApiService: UserApiService,
    private val view: UserView
) {
    fun getUsers() {
        userApiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    users?.let { view.displayUsers(it) }
                } else {
                    view.displayError("Falha ao buscar usuários")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                view.displayError("Erro: ${t.message}")
            }
        })
    }
}