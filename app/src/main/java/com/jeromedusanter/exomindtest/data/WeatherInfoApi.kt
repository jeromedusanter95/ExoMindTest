package com.jeromedusanter.exomindtest.data

import com.google.gson.annotations.SerializedName
import com.jeromedusanter.base_android.data.base.IApiModel

data class WeatherInfoApi(@SerializedName("temp") val temp: Double) : IApiModel