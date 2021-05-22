package com.modus.newsApp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.modus.newsApp.R
import com.modus.newsApp.models.Article
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.item_article.view.*

class NewsAdapter(private val imageLoader: ImageLoader) :
    ListAdapter<Article, NewsAdapter.ViewHolder>(NewsArticlesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, imageLoader)

    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Article, imageLoader: ImageLoader) {

            itemView.apply {
                imageLoader.displayImage(item.urlToImage, articleImage)
                tvSource.text = item.source.name
                tvTitle.text = item.title
                tvDescription.text = item.description
                tvPublishedAt.text = item.publishedAt
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.item_article, parent, false)
                return ViewHolder(view)
            }
        }
    }


}

class NewsArticlesDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

}