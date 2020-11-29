package com.ucs.picker.base

/**
 * Created by Raed Saeed on 29/11/2020
 **/
internal interface BaseView {
    fun startRefreshing()
    fun stopRefreshing()
    fun hideProgressBar()
    fun showProgressBar()
    fun showProgressDialog(message: String)
    fun hideProgressDialog()
    fun showFailureMessage(message: String?)
    fun showNoData() {}
    fun isConnected(): Boolean {
        return false
    }
}