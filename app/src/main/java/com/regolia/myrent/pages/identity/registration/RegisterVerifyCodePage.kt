package com.regolia.myrent.pages.identity.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.regolia.myrent.pages.identity.shared.VerifyEmailPage
import com.regolia.myrent.pages.identity.shared.VerifyWhatsAppPage


@Composable
fun RegisterVerifyCodePage(viewModel: RegisterViewModel) {

    Column(Modifier.padding(16.dp)) {
        if(viewModel.selectedChannel.id == "email") {
            VerifyEmailPage(email = viewModel.contact)
        }else if(viewModel.selectedChannel.id == "whatsapp"){
            VerifyWhatsAppPage(email = viewModel.contact)
        }

        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { viewModel.nav.navigate("userName") }) {
                Text(text = "Suivant")
            }
        }
    }
}