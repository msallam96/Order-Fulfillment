package com.ucs.picker.login.data

import com.squareup.moshi.Json

class OrderDetailsRequest {
    @Json(name = "id")
    private var id: String? = null

    @Json(name = "mage_order_id")
    private var mage_order_id: String? = null

    @Json(name = "user_id")
    private var user_id: String? = null

    @Json(name = "sku")
    private var sku: String? = null

    @Json(name = "status")
    private var status: String? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getUser_id(): String? {
        return user_id
    }

    fun setUser_id(user_id: String?) {
        this.user_id = user_id
    }

    fun getMage_order_id(): String? {
        return mage_order_id
    }

    fun setMage_order_id(mage_order_id: String?) {
        this.mage_order_id = mage_order_id
    }

    fun getSku(): String? {
        return sku
    }

    fun setSku(sku: String?) {
        this.sku = sku
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }
}