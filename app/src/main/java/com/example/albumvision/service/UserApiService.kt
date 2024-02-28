package com.example.albumvision.service

import com.example.albumvision.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserApiService {
    @GET("/")
    fun getUsers(): Call<List<User>>
}