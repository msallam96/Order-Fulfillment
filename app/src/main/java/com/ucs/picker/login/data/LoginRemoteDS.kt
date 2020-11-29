package com.ucs.picker.login.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRemoteDS {
    @POST("login/loginpost")
    suspend fun login(@Body loginRequest: LoginRequest?): LoginResponse

    @POST("order/orderlist")
    suspend fun deliveryOrder(@Body deliverOrderRequest: DeliverOrderRequest): DeliverOrderResponse

    @POST("order/orderdetails")
    suspend fun orderItemList(@Body orderDetailsRequest: OrderDetailsRequest): OrderDetailsResponse

    @POST("invoice/generateinvoice")
    suspend fun generateInvoice(@Body generateInvoiceRequest: GenerateInvoiceRequest): GenerateInvoiceResponse

    @POST("product/getproductdetials")
    suspend fun getBarCodeResult(@Body barcodeResultRequest: BarcodeResultRequest): BarcodeResultResponse

    @POST("invoice/print")
    suspend fun printInvoice(@Body printRequest: PrintRequest): PrintResponse
}