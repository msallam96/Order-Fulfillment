package com.ucs.picker.login.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ucs.picker.login.data.LoginRequest
import com.ucs.picker.login.data.LoginResponse
import com.ucs.picker.login.domain.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel @ViewModelInject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {
    private var _usersList = MutableLiveData<LoginResponse>()
    val usersList = _usersList

    fun getUsers(loginRequest: LoginRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _usersList.value = loginRepository.login(loginRequest)
            } catch (e: Exception) {
                Log.d("Error", e.message)
            }
        }
    }
}