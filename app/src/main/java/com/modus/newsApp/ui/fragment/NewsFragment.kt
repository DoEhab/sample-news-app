package com.modus.newsApp.ui.fragment

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.modus.newsApp.NewsApplication
import com.modus.newsApp.R
import com.modus.newsApp.adapter.NewsAdapter
import com.modus.newsApp.databinding.NewsFragmentBinding
import com.modus.newsApp.viewModel.NewsViewModelFactory
import com.modus.newsApp.viewModel.impl.NewsViewModel
import com.nostra13.universalimageloader.core.ImageLoader
import javax.inject.Inject

class NewsFragment : BaseFragment<NewsViewModel, NewsFragmentBinding>() {

    @Inject
    lateinit var viewModelFactory: NewsViewModelFactory

    @Inject
    lateinit var imageLoader: ImageLoader


    override fun initializeComponents(view: View) {
        val application = activity?.application as NewsApplication
        application.getComponent().inject(this)
        val factory = viewModelFactory
        viewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)
        dataBindingView.newsViewModel = viewModel
        dataBindingView.lifecycleOwner = this
        setRVAdapter()
    }


    private fun setRVAdapter() {
        dataBindingView.rvBreakingNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = NewsAdapter( imageLoader)

        dataBindingView.rvBreakingNews.adapter =
            adapter
        viewModel.newsList.observe(this, Observer { newsList ->

            adapter.submitList(newsList.articles)
        })
    }


    override fun getLayoutId(): Int = R.layout.news_fragment

    override fun progressMessage(): Int = R.string.please_wait

    override fun snackBarParentLayout(): View = dataBindingView.main

}
