package com.example.mobile4

import okhttp3.Response
import retrofit2.http.GET

interface NewEventsApi
{
    @GET("/news")
    suspend fun getNews() : List<News>
}