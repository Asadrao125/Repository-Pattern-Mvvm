package com.technado.repositorypatternmvvm.network

import com.technado.repositorypatternmvvm.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query: String): RecyclerList
}