package com.jeromedusanter.exomindtest.data

import com.jeromedusanter.base_android.data.base.IMapper
import com.jeromedusanter.exomindtest.domain.models.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor() : IMapper<Weather, WeatherApi, Nothing> {

    override fun mapModelToApiModel(model: Weather): WeatherApi =
        throw Exception("No use case yet for this method, it should never been called")


    override fun mapModelToLocalModel(model: Weather): Nothing =
        throw Exception("No use case yet for this method, it should never been called")


    override fun mapApiModelToModel(model: WeatherApi): Weather {
        return Weather(
            temperature = model.weatherInfo.temp,
            cloudiness = model.clouds.cloudiness
        )
    }

    override fun mapLocalModelToModel(model: Nothing): Weather =
        throw Exception("No use case yet for this method, it should never been called")

}