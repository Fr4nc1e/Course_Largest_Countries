package com.course.largestcountries

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    val context = LocalContext.current
                    val countries = resources.getStringArray(R.array.countries_array)
                    val areas = resources.getStringArray(R.array.areas_array)
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
                    )

                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(countries.size) {
                            Column(
                                modifier = Modifier,
                            ) {
                                Row(
                                    modifier = Modifier.clickable {
                                        Toast.makeText(
                                            context,
                                            countries[it].toString() + " " +
                                                areas[it],
                                            Toast.LENGTH_LONG,
                                        ).show()
                                    }
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                ) {
                                    Image(
                                        painter = painterResource(id = flags[it]),
                                        contentDescription = null,
                                        modifier = Modifier.width(60.dp).height(60.dp),
                                    )
                                    Column {
                                        Text(
                                            text = countries[it],
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(
                                                    paddingValues = PaddingValues(
                                                        top = 8.dp,
                                                        start = 12.dp,
                                                    ),
                                                ),
                                            fontSize = 20.sp,
                                        )
                                        Text(
                                            text = areas[it],
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(
                                                    paddingValues = PaddingValues(
                                                        top = 8.dp,
                                                        start = 12.dp,
                                                    ),
                                                ),
                                            fontSize = 14.sp,
                                        )
                                    }
                                }
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    }
}
