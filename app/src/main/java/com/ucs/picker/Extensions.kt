package com.ucs.picker

import android.widget.EditText

/**
 * Created by Raed Saeed on 29/11/2020
 **/
fun EditText.checkText(): Boolean {
    if (text.toString().isEmpty()) {
        error = context?.getString(R.string.required)
        return false
    }
    return true
}