package com.regolia.myrent.pages.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.regolia.myrent.entities.Space
import com.regolia.myrent.realm.AppRealm
import io.realm.kotlin.ext.query


@Composable
fun SpaceListPage() {
    val listState = rememberLazyListState()
    val spaces = AppRealm.instance().realm.query<Space>().find().toList()

    LazyColumn(state = listState) {
        item {
            Text(text = "Vos espaces", style = MaterialTheme.typography.titleMedium)
        }

        items(spaces, key = {it.id.toString()}) {
            Column {
                Text(text = it.name + " id: ${it.id}")
                Text(text = it.localCreatedAt.toString())
            }
        }
    }
}