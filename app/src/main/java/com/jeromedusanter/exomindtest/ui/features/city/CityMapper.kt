package com.jeromedusanter.exomindtest.ui.features.city

import android.content.Context
import com.jeromedusanter.base_android.ui.base.IMapper
import com.jeromedusanter.exomindtest.R
import com.jeromedusanter.exomindtest.domain.models.City
import java.math.RoundingMode
import javax.inject.Inject

class CityMapper @Inject constructor(private val context: Context) : IMapper<City, CityUiModel> {

    override fun mapModelToUiModel(model: City): CityUiModel {
        return CityUiModel(
            name = model.name,
            temperature = context.getString(
                R.string.temperature_in_celsius,
                convertKelvinToCelsius(model.temperature).mapToOneDecimalDouble().toString()
            ),
            cloudiness = context.getString(
                R.string.cloudiness_in_percent,
                context.getString(R.string.number_in_percent, model.cloudiness)
            )
        )
    }

    override fun mapUiModelToModel(model: CityUiModel): City =
        throw Exception("No use case yet for this method, it should never been called")

    private fun convertKelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.15
    }

    private fun Double.mapToOneDecimalDouble(): Double =
        toBigDecimal().setScale(1, RoundingMode.HALF_EVEN).toDouble()
}