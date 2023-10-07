package com.regolia.myrent.pages.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.regolia.myrent.identity.services.AuthenticationService

@Composable
fun HomePage(nav: NavController) {
    val viewModel = viewModel { HomePageViewModel() }
    viewModel.nav = nav

    HomePageScaffold(viewModel) {
        Text(text = AuthenticationService.instance().message())

        SpaceListPage()
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScaffold(viewModel: HomePageViewModel, content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("MyRent") },
                actions = {
                    Box {
                        IconButton(onClick = { viewModel.expandMenu = true }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
                        }
                        HomePageMenu(viewModel)
                    }
                }
            )
        })
    {
        Column(
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
        DropdownMenuItem(onClick = {
            viewModel.expandMenu = false
            viewModel.nav.navigate("spaces/add")
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Créer votre espace")
        }
        DropdownMenuItem(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Paramètres")
        }
    }
}