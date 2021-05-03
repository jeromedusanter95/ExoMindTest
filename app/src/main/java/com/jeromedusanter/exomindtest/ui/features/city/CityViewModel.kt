package com.jeromedusanter.exomindtest.ui.features.city

import androidx.databinding.ObservableField
import com.jeromedusanter.base_android.ui.base.BaseViewModel
import com.jeromedusanter.base_android.ui.utils.addOnPropertyChanged
import com.jeromedusanter.exomindtest.domain.models.City
import com.jeromedusanter.exomindtest.domain.usecases.GetCurrentWeatherByCityNameUseCase
import com.jeromedusanter.exomindtest.ui.features.city.list.CityListStatefulLayout
import com.jeromedusanter.exomindtest.ui.features.city.list.CityListUiModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CityViewModel @Inject constructor(
    private val getCurrentWeatherByCityNameUseCase: GetCurrentWeatherByCityNameUseCase,
    private val cityMapper: CityMapper
) : BaseViewModel<CityAction>() {

    val listUiState = ObservableField<CityListStatefulLayout.State>()
    val listUiModel = ObservableField(CityListUiModel(emptyList(), 0, 1))
    private val _cities = ObservableField(
        listOf(
            City("Rennes", 0.0, 0),
            City("Paris", 0.0, 0),
            City("Nantes", 0.0, 0),
            City("Bordeaux", 0.0, 0),
            City("Lyon", 0.0, 0)
        )
    )

    lateinit var changeTitleDisposable: Disposable

    init {
        _cities.get()?.let { getTemperaturesForAllCities(it) }

        _cities.addOnPropertyChanged {
            it.get()?.let {
                val uiModel =
                    listUiModel.get()?.copy(list = it.map { cityMapper.mapModelToUiModel(it) })
                listUiModel.set(uiModel)
            }
        }
    }

    fun refreshPage() {
        listUiModel.set(CityListUiModel(emptyList(), 0, 1))
        _cities.get()?.let { getTemperaturesForAllCities(it) }
    }

    private fun getTemperaturesForAllCities(cities: List<City>) {
        Observable.intervalRange(0, cities.size.toLong(), 0, 10, TimeUnit.SECONDS)
            .doOnNext {
                val uiMode = listUiModel.get()
                    ?.copy(progressLoading = (it + 1).toInt() * (100 / cities.size))
                listUiModel.set(uiMode)
            }
            .flatMap {
                val city = cities[it.toInt()]
                getCurrentWeatherByCityNameUseCase.execute(city.name)
                    .map { city.copy(temperature = it.temperature, cloudiness = it.cloudiness) }
            }
            .toList()
            .doOnSubscribe {
                listUiState.set(CityListStatefulLayout.State.LOADING)
                changeTitleDisposable = changeTitleEverySixSeconds().subscribe()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                changeTitleDisposable.dispose()
                _cities.set(it)
                listUiState.set(CityListStatefulLayout.State.CONTENT)
            }, {
                it.printStackTrace()
                listUiState.set(CityListStatefulLayout.State.ERROR)
            })
            .addTo(disposable)
    }

    private fun changeTitleEverySixSeconds(): Observable<Long> {
        var count = 1
        return Observable.interval(6, TimeUnit.SECONDS)
            .doOnNext {
                when (count) {
                    1 -> count++
                    2 -> count++
                    else -> count = 1
                }
                val uiMode = listUiModel.get()?.copy(titleLoading = count)
                listUiModel.set(uiMode)
            }
    }
}