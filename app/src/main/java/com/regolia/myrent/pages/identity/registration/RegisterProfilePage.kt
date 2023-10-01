package com.regolia.myrent.pages.identity.registration

import FluentOutlinedTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.regolia.myrent.pages.identity.alert.CheckContactAlert
import kotlinx.coroutines.launch


@Composable
fun RegisterProfilePage(viewModel: RegisterViewModel) {
    Column(Modifier.fillMaxWidth().padding(16.dp)) {
        Text(
            text = "Compléter votre profil",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(32.dp))

        FluentOutlinedTextField(value = viewModel.name,
            placeholder = { Text(text = "Nom & prénom")},
            onValueChange = {viewModel.name = it})
        Spacer(modifier = Modifier.height(32.dp))
        

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(modifier = Modifier.weight(1f),onClick = {
                viewModel.viewModelScope.launch {
                    viewModel.createUser()
                }
            }) {
                Text(text = "Créer le compte".uppercase())
            }
        }

        CheckContactAlert(state = viewModel.createAccountWaiting) {
            Text(
                text = "Création de votre compte",
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}