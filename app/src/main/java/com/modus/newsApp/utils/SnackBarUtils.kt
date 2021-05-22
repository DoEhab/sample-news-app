package com.modus.newsApp.utils

import android.content.Context
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.modus.newsApp.R

object SnackBarUtils {

    fun showErrorSnackBar(context: Context, coordinatorLayout: View, message: String): Snackbar {
        val snackBar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
        val sbView = snackBar.view
        sbView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorSnackBarErrorBackground))
        val textView: TextView = sbView.findViewById(R.id.snackbar_text)
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
        textView.gravity = Gravity.CENTER
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        snackBar.show()
        return snackBar
    }

    fun showSuccessSnackBar(context: Context, coordinatorLayout: View, message: String): Snackbar {
        val snackBar = Snackbar
            .make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
        val sbView = snackBar.view
        sbView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorSnackBarSuccessBackground))
        val textView: TextView = sbView.findViewById(R.id.snackbar_text)
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
        textView.gravity = Gravity.CENTER
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        snackBar.show()
        return snackBar
    }
}