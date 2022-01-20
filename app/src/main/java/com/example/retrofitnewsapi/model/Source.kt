package com.example.retrofitnewsapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Source(@SerializedName("id")
                  @Expose
                  var id: Any,
                  @SerializedName("name")
                  @Expose
                  var name: String
                  )