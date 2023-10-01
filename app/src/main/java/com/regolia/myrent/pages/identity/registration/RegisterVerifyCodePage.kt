package com.regolia.myrent.pages.identity.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.regolia.myrent.pages.identity.alert.CheckContactAlert
import com.regolia.myrent.pages.identity.shared.VerifyContactTemplate
import kotlinx.coroutines.launch


@Composable
fun RegisterVerifyCodePage(viewModel: RegisterViewModel) {


    Column(Modifier.padding(16.dp)) {
        when (viewModel.selectedChannel.id) {
            "email" -> {
                VerifyContactTemplate(
                    title = "Vérification de l'adresse E-mail",
                    onValueChange = { viewModel.code = it }
                ) {
                    Text("Vous avons envoyé un code de vérification à l'adresse mail: ${viewModel.contact}",
                        style = MaterialTheme.typography.bodyMedium)
                }

            }
            "whatsapp" -> {
                VerifyContactTemplate(
                    title = "Vérification du numéro WhatsApp",
                    onValueChange = { viewModel.code = it }
                ) {
                    Text("Vous avons envoyé un code de vérification au numéro WhatsApp: ${viewModel.contact}",
                        style = MaterialTheme.typography.bodyMedium)
                }
            }
            "telegram" -> {
                VerifyContactTemplate(
                    title = "Vérification du numéro Telegram",
                    onValueChange = { viewModel.code = it }
                ) {
                    Text("Vous avons envoyé un code de vérification au numéro Telegram: ${viewModel.contact}")
                }
            }
            "phone" -> {
                VerifyContactTemplate(
                    title = "Vérification du numéro de téléphone",
                    onValueChange = { viewModel.code = it }
                ) {
                    Text("Vous avons envoyé un code de vérification au numéro de téléphone: ${viewModel.contact}")
                }
            }
        }

        Spacer(Modifier.height(32.dp))
        Row() {
            Button(modifier = Modifier.weight(1f), onClick = {
                viewModel.viewModelScope.launch {
                    val isValid = viewModel.checkCode()
                    if(isValid) {
                        viewModel.nav.navigate("userName")
                    }
                }
            }) {
                Text(text = "Vérifier le code")
            }
        }

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        Row() {
            FilledTonalButton(modifier = Modifier.weight(1f), onClick = {

            }) {
                Text(text = "Code non reçu")
            }
        }


        CheckContactAlert(state = viewModel.checkContactWaiting) {
            Text(text = "Vérification du code", style = MaterialTheme.typography.bodyMedium)
        }
    }
}