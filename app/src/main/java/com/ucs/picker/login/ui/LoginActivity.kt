package com.ucs.picker.login.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.ucs.picker.R
import com.ucs.picker.base.BaseActivity
import com.ucs.picker.base.Response
import com.ucs.picker.checkText
import com.ucs.picker.databinding.ActivityLoginBinding
import com.ucs.picker.login.data.LoginRequest
import com.ucs.picker.login.data.LoginResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.btnActivityLogin.setOnClickListener {
            if (binding.etActivityLoginUser.checkText() && binding.etActivityLoginPass.checkText()) {
                loginViewModel.login(
                    LoginRequest(
                        binding.etActivityLoginUser.text.toString(),
                        binding.etActivityLoginPass.text.toString()
                    )
                )
            }
        }

        loginViewModel.loginResponse.observe(this, Observer {
            populateLoginResponse(it)
        })
    }

    private fun populateLoginResponse(response: Response<LoginResponse>?) {
        when (response?.status) {
            Response.Status.ERROR -> {
                response.error?.printStackTrace()
                hideProgressDialog()
            }

            Response.Status.LOADING -> {
                showProgressDialog(getString(R.string.login))
            }

            Response.Status.SUCCESS -> {
                hideProgressDialog()
                populateLoginResponse(response.data?.response_data)
            }
        }
    }

    private fun populateLoginResponse(response: LoginResponse.ResponseDataBean?) {
        if (response?.errorCode.toString() == "0") {

        } else {

        }
    }
}