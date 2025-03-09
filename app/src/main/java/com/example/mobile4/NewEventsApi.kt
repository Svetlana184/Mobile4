package com.example.mobile4

import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET

interface NewEventsApi
{
    @GET("search?country=Kazakhstan")
    fun getUnis() : Call<ArrayList<Country>>
    @GET("news")
    suspend fun getNews() : List<News>
}