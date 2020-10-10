package com.example.dailydrama


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query


//http://newsapi.org/v2/top-headlines?country=in&category=entertainment&sortBy=popularity
// &apiKey=2357eef173f14e15bf0e7e14cb872630

const val BASE_URL = "https://newsapi.org/v2/"
const val API_KEY = "2357eef173f14e15bf0e7e14cb872630"

interface NewsInterface {

    // @GET("top-headlines?country=in&category=entertainment&sortBy=popularity\n" +
    // "&apiKey=2357eef173f14e15bf0e7e14cb872630")

    @GET("top-headlines?apiKey=$API_KEY")
    fun getHeadlines(
        @Query("country")country: String,
        @Query("page") page: Int,
        @Query("category") category:String,
        @Query("sortBy") sortBy: String
    ): Call<News>


}

object NewService {
    val newsInstance: NewsInterface

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}