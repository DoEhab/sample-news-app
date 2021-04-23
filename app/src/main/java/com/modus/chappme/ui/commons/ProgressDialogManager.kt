package com.modus.chappme.ui.commons

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.TextView
import com.modus.chappme.R

class ProgressDialogManager {
    private var progressDialog: AlertDialog? = null
    fun showProgressDialog(context: Context, message: String) {
        val builder = AlertDialog.Builder(context)
        val dialogView = View.inflate(context, R.layout.dialog_progress, null)
        val tvMessage = dialogView.findViewById<TextView>(R.id.progressMessage)
        tvMessage.text = message
        builder.setView(dialogView)
        builder.setCancelable(false)
        progressDialog = builder.create()
        progressDialog?.apply {
            show()
        }
    }

    fun hideProgressDialog() {
        progressDialog?.apply {
            if (isShowing) dismiss()
        }
    }


}
