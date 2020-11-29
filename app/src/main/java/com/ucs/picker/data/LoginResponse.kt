package com.ucs.picker.data

import android.util.Printer
import com.squareup.moshi.Json

class LoginResponse {
        /**
         * response_data : {"error_code":"1","error_message":"success","user_info":{"user_id":"40","firstname":"Mahammadhusen","lastname":"Sunasara","employee_id":"203585","branch":"17","user_role":"1","branch_name":"Barsha"},"item_reasons":[{"id":"out_of_stock","reason":"Out Of Stock"},{"id":"customer_denied","reason":" Customer Denied"},{"id":"replace_with_other_item","reason":"Replace With Other Item"},{"id":"price_mismatched","reason":"Price Mismatched"},{"id":"partial_picked","reason":"Partial Picked"},{"id":"wrong_picked","reason":"Wrong Picked"}]}
         */
        var response_data: ResponseDataBean? = null

        class ResponseDataBean {
            /**
             * error_code : 1
             * error_message : success
             * user_info : {"user_id":"40","firstname":"Mahammadhusen","lastname":"Sunasara","employee_id":"203585","branch":"17","user_role":"1","branch_name":"Barsha"}
             * item_reasons : [{"id":"out_of_stock","reason":"Out Of Stock"},{"id":"customer_denied","reason":" Customer Denied"},{"id":"replace_with_other_item","reason":"Replace With Other Item"},{"id":"price_mismatched","reason":"Price Mismatched"},{"id":"partial_picked","reason":"Partial Picked"},{"id":"wrong_picked","reason":"Wrong Picked"}]
             */
            var error_code: String? = null
            var error_message: String? = null
            var user_info: UserInfoBean? = null
            var item_reasons: List<ItemReasonsBean>? = null

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
                var user_id: String? = null
                var firstname: String? = null
                var lastname: String? = null
                var employee_id: String? = null
                var branch: String? = null
                var user_role: String? = null
                var branch_name: String? = null

            }

            class ItemReasonsBean {
                /**
                 * id : out_of_stock
                 * reason : Out Of Stock
                 */
                var id: String? = null
                var reason: String? = null

                override fun equals(o: Any?): Boolean {
                    if (this === o) return true
                    if (o == null || javaClass != o.javaClass) return false
                    val that = o as ItemReasonsBean
                    return id == that.id
                } /*@Override
            public int hashCode() {
                return Objects.hash(id);
            }*/
            }
        }
    }
