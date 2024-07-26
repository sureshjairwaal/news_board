package com.example.ap_assignmen.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ap_assignmen.R
import com.example.ap_assignmen.databinding.ItemNewsBinding
import com.example.ap_assignmen.ui.home.models.ModelNewsArticles

class AdapterNews(private var items: MutableList<ModelNewsArticles.Article>, var clickListener: ((ModelNewsArticles.Article) -> Unit)) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolderImage(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderImage).bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolderImage(var binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ModelNewsArticles.Article) {
            Glide.with(binding.image.context).load(item.urlToImage).placeholder(
                R.drawable.broken_image
            ).diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.image)

            binding.date.text = item.publishedAt
            binding.title.text = item.title
            binding.subtitle.text = item.source.name
            binding.root.setOnClickListener {
                clickListener(item)
            }
        }
    }
}