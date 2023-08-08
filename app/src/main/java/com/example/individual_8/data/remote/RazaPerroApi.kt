package com.example.individual_8.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface RazaPerroApi {
    @GET("breeds/list/all")
    suspend fun getData(): Response<RazaPerro>
}