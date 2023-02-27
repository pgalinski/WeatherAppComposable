package pl.pgalinski.openwatherapicompose.ui.city

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.WeatherAppTheme
import timber.log.Timber


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityList(
    navController: NavController,
    viewModel: CityListViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        topBar = { CityListTopAppBar() },
        bottomBar = {
            CityListBottomBar()
        },
        floatingActionButton = { CityListActionButton() },
        floatingActionButtonPosition = FabPosition.End
        ) { paddingValue ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .clickable(
                    onClick = {

                    }
                )
        ) {
            items(viewModel.cities.size) { index: Int ->
                val item = viewModel.cities.get(index)
                CityListItem(index, item.name, item.selected, onClick = { selectedIndex ->
                    Timber.d("on Item click performed, selectedIndex: $selectedIndex")

                    viewModel.cities[index] = viewModel.cities[index].copy(
                        selected = !viewModel.cities[index].selected
                    )

                    viewModel.cities.forEach {
                        Timber.d("" + it)
                    }
                })
                if (index <= viewModel.cities.size) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(16.dp)
                    )
                }
            }
        }
    }



    LaunchedEffect(key1 = false) {
        viewModel.fetchCityList()
    }
}

@Composable
fun CityListActionButton() {
    FloatingActionButton(
        shape = CircleShape,
        onClick = {}
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add icon")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewCityListFAB() {
    WeatherAppTheme {
        CityListActionButton()
    }
}

@Composable
fun CityListBottomBar() {
    BottomAppBar(
        
    ){

    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewBottomBar() {
    WeatherAppTheme {
        CityListBottomBar()
    }
}


@Composable
fun CityListItem(index: Int, name: String, isSelected: Boolean = false, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick.invoke(index) }
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewCityItem() {
    WeatherAppTheme {
        CityListItem(index = 1, name = "Warszawa", onClick = {})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityListTopAppBar() {
    TopAppBar(
        title = {
            Text("Weather App")
        },
        navigationIcon = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }, actions = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Share, null)
            }
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Settings, null)
            }
        })
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewCityListAppBar() {
    WeatherAppTheme {
        CityListTopAppBar()
    }
}