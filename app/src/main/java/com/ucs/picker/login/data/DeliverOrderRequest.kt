package com.ucs.picker.login.data

import com.google.gson.annotations.SerializedName

class DeliverOrderRequest {
    @SerializedName("id")
    private var id: String? = null

    @SerializedName("mage_order_id")
    private var mage_order_id: String? = null

    @SerializedName("user_id")
    private var user_id: String? = null

    @SerializedName("sku")
    private var sku: String? = null

    @SerializedName("status")
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