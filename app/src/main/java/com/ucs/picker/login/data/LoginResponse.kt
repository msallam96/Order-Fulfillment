package com.ucs.picker.login.data

import android.util.Printer
import com.squareup.moshi.Json

class LoginResponse {
        var response_data: ResponseDataBean? = null
        class ResponseDataBean {
            var error_code: String? = null
            var error_message: String? = null
            var user_info: UserInfoBean? = null
            var item_reasons: List<ItemReasonsBean>? = null

            @Json(name = "printers")
            var printers: List<Printer>? = null
            class UserInfoBean {
                var user_id: String? = null
                var firstname: String? = null
                var lastname: String? = null
                var employee_id: String? = null
                var branch: String? = null
                var user_role: String? = null
                var branch_name: String? = null

            }

            class ItemReasonsBean {
                var id: String? = null
                var reason: String? = null

                override fun equals(o: Any?): Boolean {
                    if (this === o) return true
                    if (o == null || javaClass != o.javaClass) return false
                    val that = o as ItemReasonsBean
                    return id == that.id
                }
            }
        }
    }
