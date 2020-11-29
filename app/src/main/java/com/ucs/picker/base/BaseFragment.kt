package com.ucs.picker.base

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by Raed Saeed on 29/11/2020
 **/
abstract class BaseFragment : Fragment(), BaseView {

    // Custom loading dialog
    private lateinit var loadingDialog: LoadingDialog
    private lateinit var mContext : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun startRefreshing() {

    }

    override fun stopRefreshing() {

    }

    override fun hideProgressBar() {

    }

    override fun showProgressBar() {

    }

    override fun showFailureMessage(message: String?) {

    }


    /**
     * Show a progress dialog
     *
     * @param message that showing in loading dialog
     */
    override fun showProgressDialog(message: String) {
        // check if loading dialog is not null
        // if is null dismiss it and create new one
        val manager: FragmentManager = childFragmentManager
        if (manager.findFragmentByTag("loading") != null) {
            manager.beginTransaction().remove(loadingDialog).commitNowAllowingStateLoss()
        }
        loadingDialog = LoadingDialog.getInstance(message)
        loadingDialog.show(manager, "loading")
    }


    /**
     * dismiss loading dialog
     */
    override fun hideProgressDialog() {
        val manager: FragmentManager = childFragmentManager
        if (manager.findFragmentByTag("loading") != null) {
            manager.beginTransaction().remove(loadingDialog).commitNowAllowingStateLoss()
        }
    }

}