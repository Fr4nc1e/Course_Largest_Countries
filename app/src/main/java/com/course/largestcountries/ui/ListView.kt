package com.course.largestcountries.ui

import android.widget.Toast
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListView(
    countries: List<String>,
    areas: List<String>,
    flags: List<Int>,
) {
    val context = LocalContext.current
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(countries.size) {
            Column(
                modifier = Modifier,
            ) {
                Row(
                    modifier = Modifier.clickable {
                        Toast.makeText(
                            context,
                            countries[it] + " " +
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
