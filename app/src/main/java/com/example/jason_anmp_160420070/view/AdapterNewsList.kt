package com.example.jason_anmp_160420070.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.jason_anmp_160420070.databinding.NewsListItemBinding
import com.example.jason_anmp_160420070.model.News
import com.squareup.picasso.Picasso

class AdapterNewsList(val newsList:ArrayList<News>): RecyclerView.Adapter<AdapterNewsList.NewsViewHolder>() {
    class NewsViewHolder(var binding: NewsListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):NewsViewHolder {
        val binding = NewsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.txtAuthor.text = "By: " + newsList[position].author
        holder.binding.txtNewsTitle.text = newsList[position].title
        holder.binding.txtSummary.text = newsList[position].summary
        Picasso.get().load(newsList[position].newsPicDir).fit().centerCrop().into(holder.binding.imageView)


        holder.binding.btnDetail.setOnClickListener {
            val action = FragmentNewsListDirections.actionFragmentNewsListToFragmentNewsDetails(newsList[position].id!!, 1)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateNewsList(newNewsList: List<News>) {
        newsList.clear()
        newsList.addAll(newNewsList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
