package com.example.retrofitnewsapi

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitnewsapi.Adaptar.NewsAdaptar
import com.example.retrofitnewsapi.model.Article
import com.example.retrofitnewsapi.model.News
import com.littlemango.stacklayoutmanager.StackLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adaptar: NewsAdaptar
    lateinit var mRecyclerView: RecyclerView
    private var mArticle = mutableListOf<Article>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.newsList)
        adaptar = NewsAdaptar(this@MainActivity, mArticle)
        mRecyclerView.adapter = adaptar
//        mRecyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
        val layoutManager = StackLayoutManager(StackLayoutManager.ScrollOrientation.BOTTOM_TO_TOP)
        layoutManager.setPagerMode(true)
        layoutManager.setPagerFlingVelocity(3000)
        layoutManager.setItemChangedListener(object : StackLayoutManager.ItemChangedListener {
            override fun onItemChanged(position: Int) {
                val container = findViewById<ConstraintLayout>(R.id.container)
                container.setBackgroundColor(Color.parseColor(CollorPicker.getColor()))
            }
        })
        mRecyclerView.layoutManager = layoutManager

        getNews()
    }

    private fun getNews() {
        val newss = NewsService.newsInstance.getNewsHeadlines("us", "1")
        newss.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("AbdulKhan", news.toString())
                    mArticle.addAll(news.articles)
                    adaptar.notifyDataSetChanged()
                }
//                if (response.isSuccessful) {
//                    Log.d("TAG", "onResponse: successful")
//                    Log.d("TAG", "onResponse: articles: ${response.body()}")
//                } else
//                    Log.d("TAG", "onResponse: not successful")
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("TAG", "onFailure: not successful")
            }
        })
    }
}