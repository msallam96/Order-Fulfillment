package com.ucs.picker.login.data

import com.squareup.moshi.Json

class GenerateInvoiceResponse {
    @Json(name = "response_data")
    private var responseData: GenerateInvoiceResponse? = null

    fun getResponseData(): GenerateInvoiceResponse? {
        return responseData
    }

    fun setResponseData(responseData: GenerateInvoiceResponse?) {
        this.responseData = responseData
    }

    class ResponseDataBean {

        private var error_code: String? = null
        private var error_message: String? = null

        @Json(name = "invoice_id")
        private var invoiceId: String? = null

        fun getError_code(): String? {
            return error_code
        }

        fun setError_code(error_code: String?) {
            this.error_code = error_code
        }

        fun getError_message(): String? {
            return error_message
        }

        fun setError_message(error_message: String?) {
            this.error_message = error_message
        }

        fun getInvoiceId(): String? {
            return invoiceId
        }

        fun setInvoiceId(invoiceId: String?) {
            this.invoiceId = invoiceId
        }
    }
}