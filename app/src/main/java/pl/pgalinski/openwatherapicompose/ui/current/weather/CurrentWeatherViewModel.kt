package pl.pgalinski.openwatherapicompose.ui.current.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pgalinski.openwatherapicompose.model.curren.weather.CurrentWeather
import pl.pgalinski.openwatherapicompose.repository.CurrentWeatherRepository
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val currentWeatherRepository: CurrentWeatherRepository
) : ViewModel() {

    private val currentWeather = MutableLiveData<CurrentWeather>()

    fun fetchCurrentWeather(lat: Float, lon: Float) = viewModelScope.launch{
        val result = currentWeatherRepository.fetchCurrentWeather(lat, lon)

        if(result.isSuccess){
            currentWeather.postValue(
                result.getOrNull()
            )
        }

    }

}