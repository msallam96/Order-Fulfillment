package com.ucs.picker.login.data

import com.google.gson.annotations.SerializedName

class PrintResponse {
    @SerializedName("response_data")
    private var responseData: GenerateInvoiceResponse.ResponseDataBean? = null

    fun getResponseData(): GenerateInvoiceResponse.ResponseDataBean? {
        return responseData
    }

    fun setResponseData(responseData: GenerateInvoiceResponse.ResponseDataBean?) {
        this.responseData = responseData
    }

    class ResponseDataBean {
        var error_code: String? = null
        var error_message: String? = null

    }
}