package pl.pgalinski.openwatherapicompose.ui.city

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CityList(
    navController: NavController,
    viewModel: CityListViewModel = hiltViewModel()
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .background(Color.LightGray)
    ){
        items(viewModel.cities){item: CityState ->
            CityListItem(item.name, item.selected)
        }
    }

    LaunchedEffect(key1 = true){
        viewModel.fetchCityList()
    }
}


@Composable
@Preview
fun CityListItem(name: String = "Warszawa", isSelected: Boolean = true){
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(color = if (isSelected) Color.Gray else Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = name
            )
        }
    }
}