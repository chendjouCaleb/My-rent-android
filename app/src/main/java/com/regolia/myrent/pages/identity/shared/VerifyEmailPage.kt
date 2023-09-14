package com.regolia.myrent.pages.identity.shared

import FluentOutlinedTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun VerifyEmailPage(email: String) {
    var code by remember { mutableStateOf("") }
    Column {
        Text(text = "Vérification de l'adresse e-mail", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Vous avons envoyé un code de vérification à l'adresse mail: $email")

        FluentOutlinedTextField(value = code, onValueChange = {code = it},
        placeholder = {Text(text = "— — —  — — —")})
        Text(text = "Entrez le code à 6 chiffres", style = MaterialTheme.typography.bodySmall)
        
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Code non reçu.")
        }
    }
}