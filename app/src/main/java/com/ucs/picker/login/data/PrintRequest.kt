package com.ucs.picker.login.data

import com.google.gson.annotations.SerializedName

class PrintRequest {
    @SerializedName("printer_type")
    private var printerType: String? = null

    @SerializedName("invoice_id")
    private var invoiceId: String? = null

    fun PrintRequest(printerType: String?, invoiceId: String?) {
        this.printerType = printerType
        this.invoiceId = invoiceId
    }

    fun getPrinterType(): String? {
        return printerType
    }

    fun setPrinterType(printerType: String?) {
        this.printerType = printerType
    }

    fun getInvoiceId(): String? {
        return invoiceId
    }

    fun setInvoiceId(invoiceId: String?) {
        this.invoiceId = invoiceId
    }
}