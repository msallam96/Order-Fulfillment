package com.ucs.picker.login.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Raed Saeed on 29/11/2020
 **/
class LoginRequest(
    @SerializedName("username")
    @Expose
    val userName: String,
    @SerializedName("password")
    @Expose
    val password: String
)