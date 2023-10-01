package com.regolia.myrent.pages.identity.alert

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckContactAlert(state: MutableState<Boolean>, content: @Composable () -> Unit) {

    if(state.value) {
        AlertDialog(onDismissRequest = { /*TODO*/ }) {
            Surface(color = MaterialTheme.colorScheme.surface) {
                Row(Modifier.fillMaxWidth().padding(24.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularProgressIndicator(Modifier.width(48.dp))
                    Spacer(modifier = Modifier.width(24.dp))
                    content()
                }
            }
        }
    }
}