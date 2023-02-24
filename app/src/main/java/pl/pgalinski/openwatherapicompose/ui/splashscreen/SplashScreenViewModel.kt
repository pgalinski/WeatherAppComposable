package pl.pgalinski.openwatherapicompose.ui.splashscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pgalinski.openwatherapicompose.model.curren.weather.CurrentWeather
import pl.pgalinski.openwatherapicompose.repository.CurrentWeatherRepository
import java.lang.reflect.Constructor
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor() : ViewModel() {

    var textToshow by mutableStateOf("This is from view model")

}