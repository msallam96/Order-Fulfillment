package com.ucs.picker.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ucs.picker.data.User
import com.ucs.picker.domain.UsersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel @ViewModelInject constructor(private val usersRepository: UsersRepository) :
    ViewModel() {
    private var _usersList = MutableLiveData<List<User>>()
    val usersList = _usersList

    fun getUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _usersList.value = usersRepository.getUsers()
            } catch (e: Exception) {
                Log.d("Error", e.message)
            }
        }
    }
}