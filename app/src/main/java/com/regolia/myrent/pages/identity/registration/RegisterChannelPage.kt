package com.regolia.myrent.pages.identity.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.regolia.myrent.R
import com.regolia.myrent.pages.identity.login.EmailPage
import com.regolia.myrent.pages.identity.shared.PhoneNumberPage
import com.regolia.myrent.pages.identity.shared.TelegramNumberPage
import com.regolia.myrent.pages.identity.shared.WhatsAppNumberPage


@Composable
fun RegisterChannelPage(viewModel: RegisterViewModel) {
    Column(Modifier.fillMaxWidth()) {

        Row {
            FilledTonalButton(onClick = {
                viewModel.showChannelPicker.value = true
            }, modifier = Modifier.weight(1f)) {
                Image(
                    painter = painterResource(viewModel.selectedChannel.image),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = viewModel.selectedChannel.title,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Icon(
                    painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                    contentDescription = ""
                )
            }
        }

        Text(
            text = "Vous pouvez choisir un autre moyen de connection",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.alpha(.5f)
        )

        Spacer(modifier = Modifier.height(32.dp))

        when (viewModel.selectedChannel.id) {
            "email" -> { EmailPage({viewModel.userId = it})  }
            "whatsapp" -> {  WhatsAppNumberPage({viewModel.userId = it})  }
            "telegram" -> {  TelegramNumberPage({viewModel.userId = it})  }
            "phone" -> { PhoneNumberPage({viewModel.userId = it}) }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Text(text = viewModel.userId)

        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { viewModel.nav.navigate("verify") }) {
                Text(text = "Suivant")
            }
        }

    }
}