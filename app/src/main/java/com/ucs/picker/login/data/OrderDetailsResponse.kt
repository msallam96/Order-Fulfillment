package com.ucs.picker.login.data

import android.content.ClipData
import android.text.TextUtils
import com.squareup.moshi.Json
import java.io.Serializable

class OrderDetailsResponse {
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
        var order_info: OrderInfoBean? = null
        var item_list: List<ClipData.Item>? = null

        class OrderInfoBean : Serializable {
            var order_id: String? = null
            var name: String? = null
            var mobile: String? = null
            var order_date: String? = null
            var replace_option: String? = null
            var reserverd_total_amount: String? = null
            var payment_method: String? = null

            @Json(name  = "payment_title")
            var paymentMethodTitle: String? = null
            var status: String? = null

            @Json(name="hold_amount_percentage")
            var holdAmountPercentage: String? = null
                get() = if (TextUtils.isEmpty(field)) {
                    "0"
                } else field

            @Json(name="invoice_id")
            var invoiceId: String? = null

            // processed
            val statusId: Int
                get() {
                    return if ("progress".equals(status, ignoreCase = true) || "delivered".equals(
                            status,
                            ignoreCase = true
                        )
                    ) {
                        0 // processed
                    } else 1
                }
        }

        class ItemListBean {
            var id: String? = null
            var mage_item_id: String? = null
            var brands_code: String? = null
            var brands_name: String? = null
            var name: String? = null
            var cat3_code: String? = null
            var cat3_name: String? = null
            var qty_ordered: String? = null
            var price: String? = null
            var price_incl_tax: String? = null
            var suom: String? = null
            var promotion_status: String? = null
            var image: String? = null

        }
    }
}