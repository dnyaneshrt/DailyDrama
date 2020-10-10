package com.example.dailydrama

object ColorPicker {
    val colors = arrayOf(
        "#90A4AE", "#BCAAA4", "#FFAB91", "#FFE082", "#B9F6CA", "#81D4FA", "#80CBC4","#B39DDB","#F48FB1"
    )


    val colors1 =
        arrayOf("#37474F", "#4E342E", "#FF5722", "#FF6F00","#00C853", "#0277BD", "#00695C","#4527A0","#AD1457")

    var colorIndex = 1
    var colorIndex1 = 1
    fun getColor(): String {
        return colors[colorIndex++ % colors.size]
    }

    fun getColor1(): String {
        return colors1[colorIndex1++ % colors1.size]
    }
}