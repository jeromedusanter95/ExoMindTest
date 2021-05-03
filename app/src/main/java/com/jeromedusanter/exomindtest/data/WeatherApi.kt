package com.jeromedusanter.exomindtest.data

import com.google.gson.annotations.SerializedName
import com.jeromedusanter.base_android.data.base.IApiModel

data class WeatherApi(
    @SerializedName("main") val weatherInfo: WeatherInfoApi,
    @SerializedName("clouds") val clouds: CloudsApi
) : IApiModel