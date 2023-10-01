package com.regolia.myrent.pages.identity.shared

import FluentOutlinedTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun VerifyContactTemplate(
    title: String,
    onValueChange: (text: String) -> Unit,
    body: @Composable () -> Unit
) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        body()
        Spacer(modifier = Modifier.height(8.dp))
        var code by remember { mutableStateOf("") }
        FluentOutlinedTextField(
            value = code,
            onValueChange = {
                code = it
                onValueChange(it)

            },
            placeholder = { Text(text = "— — —  — — —") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Entrez le code à 6 chiffres",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.alpha(.6f)
            )
    }


}