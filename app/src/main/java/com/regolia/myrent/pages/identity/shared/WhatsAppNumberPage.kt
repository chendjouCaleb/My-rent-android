package com.regolia.myrent.pages.identity.shared

import FluentOutlinedTextField
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WhatsAppNumberPage(onValueChange: (value: String) -> Unit) {
    val viewModel = viewModel { PhoneNumberViewModel() }

    Column(Modifier.animateContentSize()) {
        Text(
            text = "Nous devons vérifier votre numéro WhatsApp",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))


        var country by remember { mutableStateOf("cameroun") }
        FluentOutlinedTextField(
            value = country, onValueChange = { country = it },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = ""
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth()) {
            FluentOutlinedTextField(
                value = viewModel.indicator, onValueChange = {},
                modifier = Modifier.width(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            FluentOutlinedTextField(
                value = viewModel.value,
                onValueChange = {
                    viewModel.value = it
                    onValueChange(viewModel.phoneNumber())
                },
                placeholder = { Text(text = "N° de téléphone WhatsApp") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.weight(1f)
            )
        }
    }
}