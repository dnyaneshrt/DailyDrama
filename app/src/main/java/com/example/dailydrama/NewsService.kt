package com.example.dailydrama


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//const val BASE_URL = "https://newsapi.org/v2/top-headlines?country=us&apiKey=6673568965c247589f0e41569795df5e"
const val BASE_URL = "https://newsapi.org/v2/"
const val API_KEY = "c435eb17b65c400db4d7b8403776ff78"

interface NewsInterface {

    //?apiKey=${API_KEY}
    @GET("top-headlines")
    fun getHeadlines(
        @Query("country")country: String,
        @Query("page") page: Int,
        @Query("category") category:String,
        @Query("sortBy") sortBy: String
    ): Call<News>

}
class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-Api-Key", API_KEY)
            .addHeader("User-Agent", "AndroidApp/1.0")
            .build()
        return chain.proceed(request)
    }
}

object NewService {
    val newsInstance: NewsInterface

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}