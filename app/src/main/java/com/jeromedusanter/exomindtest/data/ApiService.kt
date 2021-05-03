package com.jeromedusanter.exomindtest.data

import com.jeromedusanter.exomindtest.BuildConfig
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    fun getTemperatureByCityName(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): Observable<WeatherApi>
}