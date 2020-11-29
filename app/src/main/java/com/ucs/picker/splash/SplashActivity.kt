package com.ucs.picker.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.ucs.picker.R
import com.ucs.picker.base.BaseActivity
import com.ucs.picker.login.ui.LoginActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            goToNextScreen()
        }, 2000)
    }

    private fun goToNextScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}