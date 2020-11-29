package com.ucs.picker.domain

import com.ucs.picker.data.User
import com.ucs.picker.data.UsersRemoteDS
import javax.inject.Inject

class UsersRepository @Inject constructor(private val usersRemoteDS: UsersRemoteDS) : IUserRepository {
    override suspend fun getUsers() : List<User> {
        return usersRemoteDS.getUsers()
    }
}