package com.ucs.picker.data

import com.squareup.moshi.Json

class LoginRequest {
    @Json(name = "username")
    var userName: String? = null

    @Json(name = "password")
    var password: String? = null

}