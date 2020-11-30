package com.ucs.picker.login.ui

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.ucs.picker.BuildConfig
import com.ucs.picker.R
import com.ucs.picker.base.BaseActivity
import com.ucs.picker.base.Response
import com.ucs.picker.databinding.ActivityLoginBinding
import com.ucs.picker.login.data.LoginRequest
import com.ucs.picker.login.data.LoginResponse
import com.ucs.picker.main.MainActivity
import com.ucs.picker.utils.UserPreferences
import com.ucs.picker.utils.checkText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        if (BuildConfig.DEBUG) {
            binding.etActivityLoginUser.setText("Msunasara")
            binding.etActivityLoginPass.setText("Admin@123456789")
        }

        binding.btnActivityLogin.setOnClickListener {
            requestLogin()
        }

        loginViewModel.loginResponse.observe(this, Observer {
            populateLoginResponse(it)
        })
    }

    private fun requestLogin() {
        if (binding.etActivityLoginUser.checkText() && binding.etActivityLoginPass.checkText()) {
            loginViewModel.login(
                LoginRequest(
                    binding.etActivityLoginUser.text.toString(),
                    binding.etActivityLoginPass.text.toString()
                )
            )
        }
    }

    private fun populateLoginResponse(response: Response<LoginResponse>?) {
        when (response?.status) {
            Response.Status.ERROR -> {
                response.error?.printStackTrace()
                hideProgressDialog()
                buildAlertDialog(
                    getString(R.string.message_server_error),
                    getString(R.string.ok),
                    getString(R.string.cancel),
                    DialogInterface.OnClickListener { dialog, _ ->
                        dialog?.dismiss()
                        requestLogin()
                    },
                    DialogInterface.OnClickListener { dialog, _ ->
                        dialog.dismiss()
                    })
                    .show()
            }

            Response.Status.LOADING -> {
                showProgressDialog(getString(R.string.login))
            }

            Response.Status.SUCCESS -> {
                hideProgressDialog()
                populateLoginResponse(response.data?.responseData)
            }
        }
    }

    private fun populateLoginResponse(response: LoginResponse.ResponseDataBean?) {
        if (response?.errorCode.toString() == "0") {
            buildAlertDialog("", response?.errorMessage,
                DialogInterface.OnClickListener { dialog, which -> dialog?.dismiss() })
                .show()
        } else {
            UserPreferences.saveUserInfo(this, response?.userInfo)
            UserPreferences.saveItemReasons(this, response?.itemReasonse)
            UserPreferences.savePrinters(this, response?.printers)
            start()
        }
    }

    private fun start() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}