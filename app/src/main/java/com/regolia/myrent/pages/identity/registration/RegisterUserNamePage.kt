package com.regolia.myrent.pages.identity.registration

import FluentOutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.regolia.myrent.pages.identity.alert.CheckContactAlert
import kotlinx.coroutines.launch


@Composable
fun RegisterUseNamePage(viewModel: RegisterViewModel) {
    Column(Modifier.fillMaxWidth()) {

        Text(
            text = "Choisir un nom d'utilisateur",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "Un nom d'utilisateur permet de vous reconnaitre de facon unique sur la plateforme.",
            style = MaterialTheme.typography.bodyMedium,
           // modifier = Modifier.alpha(.7f)
        )

        Spacer(modifier = Modifier.height(32.dp))

        FluentOutlinedTextField(value = viewModel.userName,
            onValueChange = { viewModel.userName = it })
        Spacer(modifier = Modifier.height(32.dp))


        Row(modifier = Modifier.fillMaxWidth()) {
            Button(modifier = Modifier.weight(1f),
                onClick = {
                    viewModel.viewModelScope.launch {
                        val exists = viewModel.checkUserName()
                        if (!exists) {
                            viewModel.nav.navigate("profile")
                        }
                    }
                }) {
                Text(text = "Suivant")
            }
        }

        CheckContactAlert(state = viewModel.checkUserNameWaiting) {
            Text(
                text = "Vérification du nom d'utilisateur",
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}