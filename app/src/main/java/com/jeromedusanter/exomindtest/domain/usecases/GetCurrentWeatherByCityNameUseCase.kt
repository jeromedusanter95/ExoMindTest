package com.jeromedusanter.exomindtest.domain.usecases

import com.jeromedusanter.base_android.domain.base.IUseCase
import com.jeromedusanter.exomindtest.domain.boundaries.CityRepository
import com.jeromedusanter.exomindtest.domain.models.Weather
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetCurrentWeatherByCityNameUseCase @Inject constructor(
    private val repository: CityRepository
) : IUseCase<String, Observable<Weather>> {

    override fun execute(param: String?): Observable<Weather> {
        return param?.let { repository.getWeatherByCityName(it) }
            ?: Observable.error(Throwable("Params should never be null"))
    }
}