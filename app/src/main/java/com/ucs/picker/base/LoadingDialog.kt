package com.ucs.picker.base

/**
 * Created by Raed Saeed on 29/11/2020
 **/
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.ucs.picker.R


/**
 * Created by Raed Saeed on 6/18/2019.
 */
class LoadingDialog : DialogFragment() {

    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(
            context!!
        )
        val view: View = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null, false)
        builder.setView(view)
        val textView = view.findViewById<TextView>(R.id.tv_dialog_loading)
        if (arguments != null) {
            val tag = arguments!!.getString(MESSAGE)
            if (tag != null) {
                textView.text = tag
            }
        } else {
            textView.setText(R.string.processing)
        }
        val alertDialog = builder.create()
        alertDialog.setCanceledOnTouchOutside(false)
        return alertDialog
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
    }

    companion object {
        private const val TAG = "LoadingDialog"
        private const val MESSAGE = "loading_message"
        fun getInstance(message: String?): LoadingDialog {
            val loadingDialog = LoadingDialog()
            val bundle = Bundle()
            bundle.putString(MESSAGE, message)
            loadingDialog.arguments = bundle
            return loadingDialog
        }
    }
}
