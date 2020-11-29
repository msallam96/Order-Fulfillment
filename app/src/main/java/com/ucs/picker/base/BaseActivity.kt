package com.ucs.picker.base

import android.content.DialogInterface
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import com.ucs.picker.R


/**
 * Created by Raed Saeed on 29/11/2020
 * Union Coop
 **/
abstract class BaseActivity : AppCompatActivity(), BaseView {

    // Custom loading dialog
    private lateinit var loadingDialog: LoadingDialog
    private var toolbar: Toolbar? = null

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
        val manager: FragmentManager = supportFragmentManager
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
        val manager: FragmentManager = supportFragmentManager
        if (manager.findFragmentByTag("loading") != null) {
            manager.beginTransaction().remove(loadingDialog).commitNowAllowingStateLoss()
        }
    }

    /**
     * Set action bar
     *
     *
     * The toolbar is assigned to another tool in case if we want to use a full screen activity
     *
     * @param toolbar received toolbar from child activities.
     */


    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
    }

    protected fun setUpToolbar(toolbar: Toolbar, title: CharSequence?) {
        setSupportActionBar(toolbar)
        title?.let { setToolbarTitle(it) }
    }

    protected fun setUpToolbar(toolbar: Toolbar) {
        setUpToolbar(toolbar, null)
    }

    protected fun setUpToolbar(@IdRes toolbarId: Int, @StringRes titleId: Int) {
        val toolbar: Toolbar = findViewById(toolbarId)
        if (titleId != 0) {
            setUpToolbar(toolbarId, getString(titleId))
        } else {
            setUpToolbar(toolbar)
        }
    }

    protected fun setUpToolbar(@IdRes toolbarId: Int, title: String?) {
        val toolbar: Toolbar = findViewById(toolbarId)
        setUpToolbar(toolbar, title)
    }

    protected fun setToolbarTitle(title: CharSequence?) {
        getToolbar()?.let {
            supportActionBar?.title = title
        }
    }

    fun getToolbar(): Toolbar? {
        return toolbar
    }

    /**
     * This method is the super method for children
     *
     * @param item menu item to check id
     * @return if the menu item consumed in this activity or not
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun buildAlertDialog(
        @StringRes positive: Int,
        @StringRes title: Int,
        @StringRes message: Int,
        action: DialogInterface.OnClickListener
    ): AlertDialog.Builder {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(positive, action)
        return builder
    }

    /**
     * Build and Alert Dialog to notify user for something happened and needs it's interface
     *
     * @param title   alert dialog title
     * @param message alert dialog message
     * @param action  alert dialog action ok
     * @return AlertDialog Builder
     */
    protected open fun buildAlertDialog(
        title: String?,
        message: String?,
        action: DialogInterface.OnClickListener?
    ): AlertDialog.Builder {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(R.string.ok, action)
        return builder
    }

    protected open fun buildAlertDialog(
        message: String?,
        positive: String?,
        negative: String?,
        actionPositive: DialogInterface.OnClickListener?,
        actionNegative: DialogInterface.OnClickListener?
    ): AlertDialog.Builder? {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage(message)
            .setCancelable(false)
            .setPositiveButton(positive, actionPositive)
            .setNegativeButton(negative, actionNegative)
        return builder
    }
}