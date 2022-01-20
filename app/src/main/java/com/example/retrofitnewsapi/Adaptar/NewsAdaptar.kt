package com.example.retrofitnewsapi.Adaptar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitnewsapi.R
import com.example.retrofitnewsapi.model.Article

class NewsAdaptar(val context: Context,val articles:List<Article>):RecyclerView.Adapter<NewsAdaptar.ArticleViewHolder>(){
    class ArticleViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var newsImage=itemView.findViewById<ImageView>(R.id.newsImages)
        var newsTitle=itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription=itemView.findViewById<TextView>(R.id.newsDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_news, parent, false)

        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articles:Article=articles[position]
        holder.newsTitle.text=articles.title
        holder.newsDescription.text=articles.description
        Glide.with(context).load(articles.urlToImage).into(holder.newsImage)
        holder.itemView.setOnClickListener{
            Toast.makeText(context, articles.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
       return articles.size
    }
}