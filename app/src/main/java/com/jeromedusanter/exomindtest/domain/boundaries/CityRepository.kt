package com.jeromedusanter.exomindtest.domain.boundaries

import com.jeromedusanter.exomindtest.domain.models.Weather
import io.reactivex.Observable

interface CityRepository {
    fun getWeatherByCityName(cityName: String): Observable<Weather>
}