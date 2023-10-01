package com.regolia.myrent.pages.identity.registration

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RegistrationPage() {
    val viewModel = viewModel {RegisterViewModel()}
    viewModel.nav = rememberAnimatedNavController()

Scaffold(
    topBar = { TopAppBar(title = {Text("Créer un compte")},
    navigationIcon = {
        IconButton(onClick = { viewModel.nav.popBackStack() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
        }
    }) })
{
    Column(
        Modifier
            .padding(it)
            .fillMaxSize()) {

        Spacer(modifier = Modifier.height(32.dp))

        AnimatedNavHost(navController = viewModel.nav, startDestination = "channel") {
            composable("channel") {
                RegisterChannelPage(viewModel)
            }

            composable("verify") {
                RegisterVerifyCodePage(viewModel)
            }

            composable("userName") {
                RegisterUseNamePage(viewModel)
            }

            composable("profile") {
                RegisterProfilePage(viewModel)
            }
        }
    }
}

}