package com.example.retrofitnewsapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class News(@SerializedName("status")
                 @Expose
                 var status: String,
                @SerializedName("totalResults")
                 @Expose
                 var totalResults: Int,
                @SerializedName("articles")
                 @Expose
                 var articles: List<Article>
                 )