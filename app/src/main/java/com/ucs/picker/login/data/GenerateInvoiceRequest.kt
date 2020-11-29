package com.ucs.picker.login.data

import com.squareup.moshi.Json
import java.util.*

class GenerateInvoiceRequest {
    @Json(name = "order_info")
    private var orderInfoBean: OrderInfo? = null

    @Json(name = "item_info")
    private var items = ArrayList<ItemRequest>()

    @Json(name = "new_items")
    private var newItems = ArrayList<ItemRequest>()


    fun getOrderInfoBean(): OrderInfo? {
        return orderInfoBean
    }

    fun setOrderInfoBean(orderInfoBean: OrderInfo?) {
        this.orderInfoBean = orderInfoBean
    }

    fun getItems(): ArrayList<ItemRequest>? {
        return items
    }

    fun setItems(items: ArrayList<ItemRequest>) {
        this.items = items
    }

    fun getNewItems(): ArrayList<ItemRequest>? {
        return newItems
    }

    fun setNewItems(newItems: ArrayList<ItemRequest>) {
        this.newItems = newItems
    }

    class ItemRequest {
        var id: String? = null
        var mage_item_id: String? = null
        var qty_picked: String? = null
        var status: String? = null
        var reason: String? = null
        var sku: String? = null

    }

    class OrderInfo {
        var id: String? = null
        var mage_order_id: String? = null
        var user_id: String? = null

    }
}