package com.ucs.picker.login.data

import android.content.ClipData

class BarcodeResultResponse {
    private var response_data: ResponseDataBean? = null
    fun getResponse_data(): ResponseDataBean? {
        return response_data
    }

    fun setResponse_data(response_data: ResponseDataBean?) {
        this.response_data = response_data
    }

    class ResponseDataBean {
        var error_code: String? = null
        var error_message: String? = null
        var product_info: ClipData.Item? = null

    }
}