package com.example.mobile4

import retrofit2.http.GET

interface EventsApi {
    @GET("/events")
    suspend fun getEvents() : List<Events>
}