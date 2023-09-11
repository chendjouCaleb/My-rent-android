package com.regolia.myrent.pages.identity.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.regolia.myrent.R
import com.regolia.myrent.pages.identity.AuthenticationChannelPicker
import com.regolia.myrent.ui.theme.MyRentTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Channel(val title: String, val image: Int, val id: String)

val channels = listOf(
    Channel("E-mail", R.drawable.gmail, "email"),
    Channel("Téléphone", R.drawable.telephone_128, "phone"),
    Channel("WhatsApp", R.drawable.whatsapp_128, "whatsapp"),
    Channel("Telegram", R.drawable.telegram_128, "telegram")
)

class LoginPageViewModel : ViewModel() {
    var selectedChannel by mutableStateOf(channels.first { it.id == "email" })

    var showChannelPicker by mutableStateOf(false)
}

@Composable()
fun LoginPage() {
    var viewModel = viewModel { LoginPageViewModel() }
    val showPicker = remember { mutableStateOf(false) }
    Column {
        Row {
            FilledTonalButton(onClick = {
                showPicker.value = true
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


        AuthenticationChannelPicker(
            onSelected = {
                viewModel.selectedChannel = it
            },
            selectedChannel = viewModel.selectedChannel,
            state = showPicker
        )
    }


}

@Composable
@Preview(showBackground = true)
fun LoginPagePreview() {
    MyRentTheme {
        LoginPage()
    }
}

