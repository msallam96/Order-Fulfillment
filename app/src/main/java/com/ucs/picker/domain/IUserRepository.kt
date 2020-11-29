package com.ucs.picker.domain

import com.ucs.picker.data.User

interface IUserRepository {
    suspend fun getUsers(): List<User>
}