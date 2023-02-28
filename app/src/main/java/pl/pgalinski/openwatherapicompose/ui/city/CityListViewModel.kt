package pl.pgalinski.openwatherapicompose.ui.city

import androidx.compose.runtime.mutableStateListOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pgalinski.openwatherapicompose.repository.CityRepository

import javax.inject.Inject

data class CityState(
    val id: Long,
    val name: String,
    var selected: Boolean = false
)

@HiltViewModel
class CityListViewModel @Inject constructor(
    private val cityRepository: CityRepository
) : ViewModel() {

    var cities = mutableStateListOf<CityState>()

    fun fetchCityList() {
        viewModelScope.launch{
            cities.clear()
            cities.addAll(
                cityRepository.fetchCityList().map { city ->
                    CityState(
                        id = city.id,
                        name = city.name
                    )
                })
        }
    }

}