package com.ucs.picker.login.domain

import com.ucs.picker.login.data.LoginRequest
import com.ucs.picker.login.data.LoginResponse

interface ILoginRepository {
    suspend fun login(loginRequest:LoginRequest): LoginResponse
}