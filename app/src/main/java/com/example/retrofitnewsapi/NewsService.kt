package com.example.retrofitnewsapi


import com.example.retrofitnewsapi.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY
//https://newsapi.org/v2/everything?q=apple&from=2021-12-20&to=2021-12-20&sortBy=popularity&apiKey=API_KEY


//https://newsapi.org/v2/top-headlines?apikey=c92fcb9a055c41da855425cef2b26674&country=in&page=1
const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "c92fcb9a055c41da855425cef2b26674"

interface NewsInterface {

    @GET("v2/top-headlines?apikey=$API_KEY")
    fun getNewsHeadlines(@Query("country") country: String, @Query("page") page: String): Call<News>

    // https://newsapi.org/v2/top-headlines?apikey=$API_KEY&country=in&page=1
}

object NewsService {
    val newsInstance: NewsInterface

    init {
        val retrofit :Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}

