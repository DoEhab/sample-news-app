package com.modus.newsApp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.modus.newsApp.ui.commons.ProgressDialogManager
import com.modus.newsApp.utils.SnackBarUtils
import com.modus.newsApp.viewModel.impl.BaseViewModel


abstract class BaseFragment<P : BaseViewModel, V : ViewDataBinding> : Fragment() {

    private val progressDialog = ProgressDialogManager()
    lateinit var viewModel: P
    lateinit var dataBindingView: V

    private fun initialize(inflater: LayoutInflater, container: ViewGroup?) {
        dataBindingView = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        initialize(inflater, container)
        return dataBindingView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeComponents(view)
        observeLiveData()
    }

    abstract fun initializeComponents(view: View)

    abstract fun getLayoutId(): Int

    abstract fun progressMessage(): Int

    abstract fun snackBarParentLayout(): View

    private fun observeLiveData() {
        viewModel.successMessage.observe(this, Observer {
            showSuccessMessage(requireContext().getString(it))
        })

        viewModel.errorMessage.observe(this, Observer {
            showErrorMessage(requireContext().getString(it))
        })
        viewModel.backendErrorMessage.observe(this, Observer {
            if (it != null) showErrorMessage(it)
        })
        viewModel.inProgress.observe(this, Observer {
            when (it) {
                true -> showProgressDialog()
                false -> hideProgressDialog()
            }
        })
    }

    open fun showProgressDialog() {
        progressDialog.showProgressDialog(requireContext(), getString(progressMessage()))
    }

    open fun hideProgressDialog() {
        progressDialog.hideProgressDialog()
    }

    private fun showErrorMessage(errorMessage: String) {
        SnackBarUtils.showErrorSnackBar(requireContext(), snackBarParentLayout(), errorMessage)
    }

    private fun showSuccessMessage(successMessage: String) {
        SnackBarUtils.showSuccessSnackBar(requireContext(), snackBarParentLayout(), successMessage)
    }

}