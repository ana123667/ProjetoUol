package com.example.albumvision.view

import com.example.albumvision.model.User

interface UserView {
    fun displayUsers(users: List<User>)
    fun displayError(message: String)
}