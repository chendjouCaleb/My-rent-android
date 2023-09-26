package com.regolia.myrent.pages.identity.registration

import FluentOutlinedTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp


@Composable
fun RegisterUseNamePage(viewModel: RegisterViewModel) {
    Column(Modifier.fillMaxWidth()) {

        Text(
            text = "Choisir un nom d'utilisateur",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = "Un nom d'utilisateur permet de vous reconnaitre de facon unique sur la plateforme.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.alpha(.5f)
        )

        Spacer(modifier = Modifier.height(32.dp))

        FluentOutlinedTextField(value = viewModel.userName,
            onValueChange = {viewModel.userName = it})
        Spacer(modifier = Modifier.height(32.dp))


        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { viewModel.nav.navigate("profile") }) {
                Text(text = "Suivant")
            }
        }

    }
}