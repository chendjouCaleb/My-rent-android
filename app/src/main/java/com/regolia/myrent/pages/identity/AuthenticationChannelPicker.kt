package com.regolia.myrent.pages.identity

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.regolia.myrent.identity.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class,
    ExperimentalAnimationApi::class
)
@Composable
fun AuthenticationChannelPicker(
    onSelected: (channel: Channel) -> Unit,
    selectedChannel: Channel,
    state: MutableState<Boolean>
) {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    if (state.value) {
        ModalBottomSheet(sheetState = sheetState, onDismissRequest = {
            state.value = false
        }) {
            Channel.all.forEach { channel ->
                val selected = selectedChannel.id == channel.id
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(selected, onClick = {
                            onSelected(channel)
                            scope.launch {
                                delay(300)
                                sheetState.hide()
                            }
                                .invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        state.value = false
                                    }
                                }
                        })
                        .padding(vertical = 12.dp, horizontal = 32.dp)
                ) {
                    Image(
                        painter = painterResource(id = channel.image), contentDescription = "",
                        modifier = Modifier.size(48.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = channel.title, modifier = Modifier.weight(1f))

                    AnimatedVisibility(visible = selected,
                        enter = fadeIn() + scaleIn(),
                        exit = fadeOut() + scaleOut()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.animateContentSize()
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(48.dp))
        }
    }


}