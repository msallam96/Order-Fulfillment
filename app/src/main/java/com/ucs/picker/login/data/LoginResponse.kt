package com.ucs.picker.login.data

import android.util.Printer
import com.squareup.moshi.Json

class LoginResponse {
    /**
     * response_data : {"error_code":"1","error_message":"success","user_info":{"user_id":"40","firstname":"Mahammadhusen","lastname":"Sunasara","employee_id":"203585","branch":"17","user_role":"1","branch_name":"Barsha"},"item_reasons":[{"id":"out_of_stock","reason":"Out Of Stock"},{"id":"customer_denied","reason":" Customer Denied"},{"id":"replace_with_other_item","reason":"Replace With Other Item"},{"id":"price_mismatched","reason":"Price Mismatched"},{"id":"partial_picked","reason":"Partial Picked"},{"id":"wrong_picked","reason":"Wrong Picked"}]}
     */
    @Json(name = "response_data")
    var response_data: ResponseDataBean? = null

    class ResponseDataBean {
        /**
         * error_code : 1
         * error_message : success
         * user_info : {"user_id":"40","firstname":"Mahammadhusen","lastname":"Sunasara","employee_id":"203585","branch":"17","user_role":"1","branch_name":"Barsha"}
         * item_reasons : [{"id":"out_of_stock","reason":"Out Of Stock"},{"id":"customer_denied","reason":" Customer Denied"},{"id":"replace_with_other_item","reason":"Replace With Other Item"},{"id":"price_mismatched","reason":"Price Mismatched"},{"id":"partial_picked","reason":"Partial Picked"},{"id":"wrong_picked","reason":"Wrong Picked"}]
         */
        @Json(name = "error_code")
        var errorCode: String? = null

        @Json(name = "error_message")
        var errorMessage: String? = null

        @Json(name = "user_info")
        var userInfo: UserInfoBean? = null

        @Json(name = "item_reasons")
        var itemReasonse: List<ItemReasonsBean>? = null

        @Json(name = "printers")
        var printers: List<Printer>? = null

        class UserInfoBean {
            /**
             * user_id : 40
             * firstname : Mahammadhusen
             * lastname : Sunasara
             * employee_id : 203585
             * branch : 17
             * user_role : 1
             * branch_name : Barsha
             */
            @Json(name = "user_id")
            var userId: String? = null

            @Json(name = "firstname")
            var firstName: String? = null

            @Json(name = "lastname")
            var lastName: String? = null

            @Json(name = "employee_id")
            var employeeId: String? = null

            @Json(name = "branch")
            var branch: String? = null

            @Json(name = "user_role")
            var userRole: String? = null

            @Json(name = "branch_name")
            var branchName: String? = null
        }

        class ItemReasonsBean {
            /**
             * id : out_of_stock
             * reason : Out Of Stock
             */
            @Json(name = "id")
            var id: String? = null

            @Json(name = "reason")
            var reason: String? = null

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || javaClass != other.javaClass) return false
                val that = other as ItemReasonsBean
                return id == that.id
            }

            override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (reason?.hashCode() ?: 0)
                return result
            }
        }
    }
}
