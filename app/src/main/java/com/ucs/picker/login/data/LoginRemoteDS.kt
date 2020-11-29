package com.ucs.picker.login.data

import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRemoteDS {
    @POST("login/loginpost")
    suspend fun login(@Body loginRequest: LoginRequest?): LoginResponse
}