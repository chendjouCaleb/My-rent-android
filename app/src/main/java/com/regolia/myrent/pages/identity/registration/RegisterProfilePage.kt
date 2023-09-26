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
import androidx.compose.ui.unit.dp


@Composable
fun RegisterProfilePage(viewModel: RegisterViewModel) {
    Column(Modifier.fillMaxWidth()) {

        Text(
            text = "Compléter votre profil",
            style = MaterialTheme.typography.titleMedium
        )



        Spacer(modifier = Modifier.height(32.dp))

        FluentOutlinedTextField(value = viewModel.userName,
            placeholder = { Text(text = "Nom & prénom")},
            onValueChange = {viewModel.userName = it})
        Spacer(modifier = Modifier.height(32.dp))
        

        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { viewModel.nav.navigate("verify") }) {
                Text(text = "Créer le compte")
            }
        }

    }
}