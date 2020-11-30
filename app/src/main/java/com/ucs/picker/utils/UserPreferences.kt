package com.ucs.picker.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ucs.picker.login.data.LoginResponse
import java.util.*

/**
 * Created by Raed Saeed on 30/11/2020
 **/
object UserPreferences {
    private val APP_PRIVATE_SHARED_PREFERENCES_KEY = "ucs_picker_production_1.1_shared_preferences"
    private const val USER_INFO_KEY = "userinfoKey"
    private const val ITEM_REASONS = "itemreasons"
    private const val PRINTERS = "printers"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            APP_PRIVATE_SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )
    }

    private fun getSharedEditor(context: Context): SharedPreferences.Editor {
        return getSharedPreferences(context).edit()
    }

    fun saveUserInfo(context: Context, userInfo: LoginResponse.ResponseDataBean.UserInfoBean?) {
        userInfo?.let {
            val userJson = Gson().toJson(userInfo)
            getSharedEditor(context).putString(USER_INFO_KEY, userJson).apply()
        }
    }

    fun getUserInfo(context: Context): LoginResponse.ResponseDataBean.UserInfoBean? {
        val userString = getSharedPreferences(context).getString(USER_INFO_KEY, "")
        if (userString.isNullOrEmpty()) {
            return null
        }
        return Gson().fromJson(userString, LoginResponse.ResponseDataBean.UserInfoBean::class.java)
    }

    fun saveItemReasons(
        context: Context,
        itemReasonList: List<LoginResponse.ResponseDataBean.ItemReasonsBean>?
    ) {
        itemReasonList?.let {
            val itemString = Gson().toJson(
                itemReasonList,
                LoginResponse.ResponseDataBean.ItemReasonsBean::class.java
            )
            getSharedEditor(context).putString(ITEM_REASONS, itemString).apply()
        }
    }

    fun getItemReasons(context: Context): List<LoginResponse.ResponseDataBean.ItemReasonsBean> {
        val itemString = getSharedPreferences(context).getString(ITEM_REASONS, "")
        if (itemString.isNullOrEmpty()) {
            return emptyList()
        }
        val listType =
            object : TypeToken<ArrayList<LoginResponse.ResponseDataBean.ItemReasonsBean>>() {}.type
        return Gson().fromJson<List<LoginResponse.ResponseDataBean.ItemReasonsBean>>(
            itemString,
            listType
        )
    }

    fun savePrinters(context: Context, printers: List<LoginResponse.ResponseDataBean.Printer>?) {
        printers?.let {
            val printerString =
                Gson().toJson(printers, LoginResponse.ResponseDataBean.Printer::class.java)
            getSharedEditor(context).putString(PRINTERS, printerString).apply()
        }
    }

    fun getPrinters(context: Context): List<LoginResponse.ResponseDataBean.Printer> {
        val printerString = getSharedPreferences(context).getString(PRINTERS, "")
        if (printerString.isNullOrEmpty()) {
            return emptyList()
        }
        val listType =
            object : TypeToken<ArrayList<LoginResponse.ResponseDataBean.Printer>>() {}.type
        return Gson().fromJson<List<LoginResponse.ResponseDataBean.Printer>>(
            printerString,
            listType
        )
    }
}