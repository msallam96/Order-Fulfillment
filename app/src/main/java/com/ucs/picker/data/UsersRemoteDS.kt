package com.ucs.picker.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersRemoteDS {
    @GET("users")
    suspend fun getUsers(): List<User>

    @POST("login/loginpost")
    suspend fun login(@Body loginRequest: LoginRequest?): LoginResponse
}