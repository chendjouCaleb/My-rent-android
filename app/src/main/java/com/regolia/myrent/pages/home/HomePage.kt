package com.regolia.myrent.pages.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.regolia.myrent.identity.services.AuthenticationService

@Composable
fun HomePage(nav: NavController) {
    val viewModel = viewModel { HomePageViewModel() }
    viewModel.nav = nav

    HomePageScaffold(viewModel) {
        Text(text = AuthenticationService.instance().message())
    }
    HomePageMenu(viewModel)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScaffold(viewModel: HomePageViewModel, content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("MyRent") },
                navigationIcon = {
                    IconButton(onClick = { viewModel.nav.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.expandMenu = true }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
                    }


                }
            )
        })
    {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            content()
        }
    }
}

@Composable
fun HomePageMenu(viewModel: HomePageViewModel) {
    DropdownMenu(
        expanded = viewModel.expandMenu,
        onDismissRequest = { viewModel.expandMenu = false }) {
        DropdownMenuItem(onClick = { /*TODO*/ }) {
            Text(text = "Paramètres")
        }
    }
}