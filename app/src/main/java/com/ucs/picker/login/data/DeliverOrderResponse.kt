package com.ucs.picker.login.data

import android.os.Parcel
import android.os.Parcelable

class DeliverOrderResponse {
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
        var order_list: List<OrderListBean>? = null

        class OrderListBean protected constructor(`in`: Parcel) : Parcelable {
            var id: String?
            var mage_order_id: String?
            var order_id: String?
            var schedule_time: String?
            var status: String?

            override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(id)
                dest.writeString(mage_order_id)
                dest.writeString(order_id)
                dest.writeString(schedule_time)
                dest.writeString(status)
            }

            override fun describeContents(): Int {
                return 0
            }

            // processed
            val statusId: Int
                get() = if ("progress".equals(status, ignoreCase = true) || "delivered".equals(
                        status,
                        ignoreCase = true
                    )
                ) {
                    0 // processed
                } else 1

            companion object {
                val CREATOR: Parcelable.Creator<OrderListBean?> =
                    object : Parcelable.Creator<OrderListBean?> {
                        override fun createFromParcel(`in`: Parcel): OrderListBean? {
                            return OrderListBean(`in`)
                        }

                        override fun newArray(size: Int): Array<OrderListBean?> {
                            return arrayOfNulls(size)
                        }
                    }
            }

            init {
                id = `in`.readString()
                mage_order_id = `in`.readString()
                order_id = `in`.readString()
                schedule_time = `in`.readString()
                status = `in`.readString()
            }
        }
    }
}