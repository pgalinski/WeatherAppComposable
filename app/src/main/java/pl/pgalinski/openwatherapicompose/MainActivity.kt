package pl.pgalinski.openwatherapicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint
import pl.pgalinski.openwatherapicompose.ui.WeatherAppNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme(
                content = {
                    WeatherAppNavigation()
                }
            )
        }
    }


}