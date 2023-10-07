package com.regolia.myrent.pages.spaces.add

import FluentOutlinedTextField
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch



@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SpaceAddPage(navHost: NavHostController) {
    val viewModel = viewModel{ SpaceAddViewModel() }
    viewModel.navHost = navHost

    Column {
        Text(
            text = "Créer le profile de votre espace.",
            style = MaterialTheme.typography.bodyMedium,
            // modifier = Modifier.alpha(.7f)
        )

        Spacer(modifier = Modifier.height(32.dp))

        FluentOutlinedTextField(value = viewModel.name,
            onValueChange = { viewModel.name = it },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "")}
            )
        Spacer(modifier = Modifier.height(16.dp))

        FluentOutlinedTextField(value = viewModel.identifier,
            onValueChange = { viewModel.identifier = it },
            leadingIcon = { Icon(Icons.Default.Badge, contentDescription = "")}
        )
        Spacer(modifier = Modifier.height(32.dp))


        Row(modifier = Modifier.fillMaxWidth()) {
            Button(modifier = Modifier.weight(1f),
                onClick = {
                    viewModel.viewModelScope.launch {
                        val exists = viewModel.addSpace()
                        if (!exists) {
                            viewModel.navHost.navigate("home")
                        }
                    }
                }) {
                Text(text = "Suivant")
            }
        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceAddPageScaffold(viewModel: SpaceAddViewModel, content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Créer un espace") },
                navigationIcon = {
                    IconButton(onClick = { viewModel.navHost.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        })
    {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)) {
            content()
        }
    }
}