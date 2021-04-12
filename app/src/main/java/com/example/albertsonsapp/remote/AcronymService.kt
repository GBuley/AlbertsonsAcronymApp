package com.example.albertsonsapp.remote

import com.example.albertsonsapp.model.AcronymResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymService {

    @GET("dictionary.py")
    suspend fun getAcronym(@Query("sf") acronymName: String): Response<List<AcronymResponseItem>>

}
