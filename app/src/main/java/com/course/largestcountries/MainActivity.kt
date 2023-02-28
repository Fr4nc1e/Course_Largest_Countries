package com.course.largestcountries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.course.largestcountries.ui.GridView
import com.course.largestcountries.ui.theme.LargestCountriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LargestCountriesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val countries = resources.getStringArray(R.array.countries_array).toList()
                    val areas = resources.getStringArray(R.array.areas_array).toList()
                    val flags = arrayOf(
                        R.drawable.russia,
                        R.drawable.canada,
                        R.drawable.usa,
                        R.drawable.china,
                        R.drawable.brazil,
                        R.drawable.australia,
                        R.drawable.india,
                        R.drawable.argentina,
                        R.drawable.kazakhstan,
                        R.drawable.algeria,
                    ).toList()
//                    ListView(
//                        countries = countries,
//                        areas = areas,
//                        flags = flags,
//                    )
                    GridView(
                        countries = countries,
                        areas = areas,
                        flags = flags,
                    )
                }
            }
        }
    }
}
