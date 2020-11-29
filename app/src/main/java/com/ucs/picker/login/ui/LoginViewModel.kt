package com.ucs.picker.login.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ucs.picker.base.Response
import com.ucs.picker.login.data.LoginRequest
import com.ucs.picker.login.data.LoginResponse
import com.ucs.picker.login.domain.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {
    var loginResponse = MutableLiveData<Response<LoginResponse>>()

    fun login(loginRequest: LoginRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                loginResponse.postValue(Response.stateLoading())
                loginResponse.postValue(Response.stateSuccess(loginRepository.login(loginRequest)))
            } catch (e: Exception) {
                loginResponse.postValue(Response.stateError(e))
            }
        }
    }
}