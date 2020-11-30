package com.ucs.picker.utils

import android.widget.EditText
import com.ucs.picker.R

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