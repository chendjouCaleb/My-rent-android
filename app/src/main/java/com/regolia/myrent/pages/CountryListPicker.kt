package com.regolia.myrent.pages

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.regolia.myrent.pages.identity.CountryList

data class CountryView(val code: String, val phoneCode: String, val flag: String)

@Composable
fun CountryListPicker() {

    val state = rememberLazyListState()
    var countries by remember { mutableStateOf(listOf<CountryView>()) }

    LaunchedEffect(Unit) {
        countries = CountryList.list.map {
            val flag = CountryList.codeToFlag(it.code)

            CountryView(it.code, it.phoneCode, flag)
        }
    }

    LazyColumn(state = state) {
        items(countries, key = {it.code}) {
            Row {
                Text(text = it.flag, fontSize = 24.sp)
            }
        }
    }
}