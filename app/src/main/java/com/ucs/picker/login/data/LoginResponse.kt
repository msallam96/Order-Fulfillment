package com.ucs.picker.login.data

import com.google.gson.annotations.SerializedName

class LoginResponse {
    /**
     * response_data : {"error_code":"1","error_message":"success","user_info":{"user_id":"40","firstname":"Mahammadhusen","lastname":"Sunasara","employee_id":"203585","branch":"17","user_role":"1","branch_name":"Barsha"},"item_reasons":[{"id":"out_of_stock","reason":"Out Of Stock"},{"id":"customer_denied","reason":" Customer Denied"},{"id":"replace_with_other_item","reason":"Replace With Other Item"},{"id":"price_mismatched","reason":"Price Mismatched"},{"id":"partial_picked","reason":"Partial Picked"},{"id":"wrong_picked","reason":"Wrong Picked"}]}
     */
    @SerializedName("response_data")
    var responseData: ResponseDataBean? = null

    class ResponseDataBean {
        /**
         * error_code : 1
         * error_message : success
         * user_info : {"user_id":"40","firstname":"Mahammadhusen","lastname":"Sunasara","employee_id":"203585","branch":"17","user_role":"1","branch_name":"Barsha"}
         * item_reasons : [{"id":"out_of_stock","reason":"Out Of Stock"},{"id":"customer_denied","reason":" Customer Denied"},{"id":"replace_with_other_item","reason":"Replace With Other Item"},{"id":"price_mismatched","reason":"Price Mismatched"},{"id":"partial_picked","reason":"Partial Picked"},{"id":"wrong_picked","reason":"Wrong Picked"}]
         */
        @SerializedName("error_code")
        var errorCode: String? = null

        @SerializedName("error_message")
        var errorMessage: String? = null

        @SerializedName("user_info")
        var userInfo: UserInfoBean? = null

        @SerializedName("item_reasons")
        var itemReasonse: List<ItemReasonsBean>? = null

        @SerializedName("printers")
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
            @SerializedName("user_id")
            var userId: String? = null

            @SerializedName("firstname")
            var firstName: String? = null

            @SerializedName("lastname")
            var lastName: String? = null

            @SerializedName("employee_id")
            var employeeId: String? = null

            @SerializedName("branch")
            var branch: String? = null

            @SerializedName("user_role")
            var userRole: String? = null

            @SerializedName("branch_name")
            var branchName: String? = null
        }

        class ItemReasonsBean {
            /**
             * id : out_of_stock
             * reason : Out Of Stock
             */
            @SerializedName("id")
            var id: String? = null

            @SerializedName("reason")
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

        /**
         * {"printer_type":"A4","printer_name":"A4 Printer"}
         */
        class Printer {
            @SerializedName("printer_type")
            var printerType: String? = null

            @SerializedName("printer_name")
            var printerName: String? = null
        }
    }
}
