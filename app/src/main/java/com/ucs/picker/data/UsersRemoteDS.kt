package com.ucs.picker.data

import retrofit2.http.GET

interface UsersRemoteDS {
    @GET("users")
    suspend fun getUsers():List<User>
}