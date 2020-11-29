package com.ucs.picker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ucs.picker.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getUsers()
        mainViewModel.usersList.observe(this, Observer {
            rvUsers.adapter = UsersAdapter(this  , it)
            rvUsers.layoutManager=LinearLayoutManager(this)
            Toast.makeText(this ,it.toString() , Toast.LENGTH_LONG).show()

        })
    }
}