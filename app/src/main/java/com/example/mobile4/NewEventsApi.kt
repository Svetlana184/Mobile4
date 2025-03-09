package com.example.mobile4

import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET

interface NewEventsApi
{
    @GET("events")
    fun getEvents() : Call<ArrayList<Events>>
    @GET("news")
    suspend fun getNews() : List<News>
}