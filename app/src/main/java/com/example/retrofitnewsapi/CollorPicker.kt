package com.example.retrofitnewsapi

object CollorPicker {
    val colors = arrayOf("#FF6633", "#FFB399", "#FF33FF", "#FFFF99","#00B3E6", "#E6B333", "#3366E6", "#999966", "#99FF99", "#B34D4D","#80B300", "#809900", "#E6B3B3", "#6680B3", "#66991A","#FF99E6")
    var colorIndex = 1
    fun getColor():String{
        return colors[colorIndex++ % colors.size]
    }
}