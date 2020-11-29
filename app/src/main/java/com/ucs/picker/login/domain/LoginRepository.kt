package com.ucs.picker.login.domain

import com.ucs.picker.login.data.LoginRemoteDS
import com.ucs.picker.login.data.LoginRequest
import com.ucs.picker.login.data.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(private val loginRemoteDS: LoginRemoteDS) :
    ILoginRepository {
    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return loginRemoteDS.login(loginRequest)
    }
}