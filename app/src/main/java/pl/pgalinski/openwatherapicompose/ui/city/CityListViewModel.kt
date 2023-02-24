package pl.pgalinski.openwatherapicompose.ui.city

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pgalinski.openwatherapicompose.model.curren.weather.CurrentWeather
import pl.pgalinski.openwatherapicompose.repository.CityRepository
import pl.pgalinski.openwatherapicompose.repository.CurrentWeatherRepository
import javax.inject.Inject

data class CityState(
    val name: String,
    val selected: Boolean = false
)

@HiltViewModel
class CityListViewModel @Inject constructor(
    private val cityRepository: CityRepository
) : ViewModel() {

    var cities = mutableStateListOf<CityState>()

    fun fetchCityList() {
        viewModelScope.launch(Dispatchers.IO) {
            cities.addAll(
                cityRepository.fetchCityList().map { city ->
                    CityState(city.name)
                })
        }

    }

}