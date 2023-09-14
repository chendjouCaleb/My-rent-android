package com.regolia.myrent.pages.identity.login

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.regolia.myrent.pages.identity.AuthenticationChannelPicker
import com.regolia.myrent.ui.theme.MyRentTheme


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LoginPage() {
    val viewModel = viewModel { LoginPageViewModel() }
    viewModel.nav = rememberAnimatedNavController()
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Text(
            text = "Se connecter", style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(32.dp))


        AnimatedNavHost(navController = viewModel.nav, startDestination = "channel") {
            composable("channel") {
                LoginChannelPage(viewModel)
            }

            composable("verify") {
                LoginVerifyCodePage(viewModel)
            }
        }


        AuthenticationChannelPicker(
            onSelected = {
                viewModel.selectedChannel = it
                viewModel.userId = ""
            },
            selectedChannel = viewModel.selectedChannel,
            state = viewModel.showChannelPicker
        )
    }


}

@Composable
@Preview(showBackground = true)
fun LoginPagePreview() {
    MyRentTheme {
        LoginPage()
    }
}

