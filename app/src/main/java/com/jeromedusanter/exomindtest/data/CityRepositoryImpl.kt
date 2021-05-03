package com.jeromedusanter.exomindtest.data

import com.jeromedusanter.exomindtest.domain.boundaries.CityRepository
import com.jeromedusanter.exomindtest.domain.models.Weather
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val weatherMapper: WeatherMapper
) : CityRepository {

    override fun getWeatherByCityName(cityName: String): Observable<Weather> {
        return apiService.getTemperatureByCityName(cityName)
            .map { weatherMapper.mapApiModelToModel(it) }
    }
}