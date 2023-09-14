package com.regolia.myrent

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.regolia.myrent.pages.WelcomePage
import com.regolia.myrent.pages.identity.login.LoginPage
import com.regolia.myrent.pages.identity.registration.RegistrationPage

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavGraph() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomePage(navController)
        }

        composable("login") {
            LoginPage()
        }

        composable("register") {
            RegistrationPage()
        }


    }
}