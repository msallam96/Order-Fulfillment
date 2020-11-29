package com.ucs.picker.login.data

import com.squareup.moshi.Json

/**
 * Created by Raed Saeed on 29/11/2020
 **/
class LoginRequest(
    @Json(name = "username") val userName: String,
    @Json(name = "password") val password: String
)