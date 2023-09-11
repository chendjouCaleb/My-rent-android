package com.regolia.myrent

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavGraph() {
    var navController = rememberAnimatedNavController()

    AnimatedNavHost(navController, startDestination = "welcome") {
        composable("welcome") {

        }

        composable("login") {

        }
    }
}