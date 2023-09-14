package com.regolia.myrent.pages.identity.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController


@Composable
fun RegistrationPage() {
    val viewModel = viewModel {RegisterViewModel()}
    viewModel.nav = rememberNavController()


    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize()) {
        Text(text = "Créer un compte", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(32.dp))


    }
}