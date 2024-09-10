package com.ex.homework2_5month.interfaces

import com.ex.homework2_5month.models.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface LoveApiService {

    @GET("getPercentage")

    fun getPercentage(
        @Header("X-Rapidapi-Key")key:String,
        @Header("X-Rapidapi-Host")host:String,
        @Query("fname")firstName:String,
        @Query("sname")secondName:String
    ):Call<LoveModel>

}