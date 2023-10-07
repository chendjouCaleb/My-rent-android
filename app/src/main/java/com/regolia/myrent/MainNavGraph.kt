package com.regolia.myrent

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.regolia.myrent.identity.services.AuthenticationService
import com.regolia.myrent.pages.WelcomePage
import com.regolia.myrent.pages.home.HomePage
import com.regolia.myrent.pages.identity.login.LoginPage
import com.regolia.myrent.pages.identity.registration.RegistrationPage
import com.regolia.myrent.pages.spaces.add.SpaceAddPage

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavGraph() {
    val navController = rememberAnimatedNavController()
    val auth = AuthenticationService.instance()

    val startUrl = if(auth.isLoggedIn()) "home" else "welcome"

    AnimatedNavHost(navController, startDestination = startUrl) {
        composable("welcome") {
            WelcomePage(navController)
        }

        composable("login") {
            LoginPage(navController)
        }

        composable("register") {
            RegistrationPage()
        }

        composable("home") {
            HomePage(navController)
        }

        composable("spaces/add") {
            SpaceAddPage(navController)
        }

    }
}