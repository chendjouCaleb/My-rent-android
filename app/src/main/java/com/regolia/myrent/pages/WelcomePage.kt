package com.regolia.myrent.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.regolia.myrent.R
import com.regolia.myrent.helpers.Lang
import com.regolia.myrent.ui.theme.Gray100
import com.regolia.myrent.ui.theme.MyRentTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomePageViewModel : ViewModel() {
    val langs = listOf<Lang>(
        Lang("Français", "Français", "fr"),
        Lang("English", "Anglais", "en"),
        Lang("Latin", "Latin", "la")
    )

    var selectedLangId by mutableStateOf("fr")

    var showLangPicker by mutableStateOf(false)

    fun getSelectedLang(): Lang {
        return langs.first { it.id == selectedLangId }
    }
}


@Composable()
fun WelcomePage() {
    val viewModel = viewModel { WelcomePageViewModel() }
    Column(modifier = Modifier.padding(32.dp)) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Text(
                "Bienvenue sur RentHub",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp, lineHeight = 32.sp
            )

            Text(
                text = "Gérer vos chambres et cités plus efficacement\n" +
                        "dès maintenant.",
                color = Gray100,
                fontSize = 20.sp,
                lineHeight = 26.sp,
                fontWeight = FontWeight.SemiBold,
            )

            Spacer(modifier = Modifier.height(48.dp))

            Row() {
                Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                    Text(text = "Créer un compte")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = buildAnnotatedString {
                append("En créant un compte, vous acceptez explicitement notre ")
                pushStringAnnotation(tag = "policy", annotation = "https://google.com/policy")
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append("Politique de confidentialité")
                }
                pop()
                append(" et nos ")

                pushStringAnnotation(tag = "terms", annotation = "https://google.com/terms")
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append("Conditions d'utilisation\"")
                }
                pop()
                append(".")

            }, style = MaterialTheme.typography.bodySmall)

            Divider(Modifier.padding(vertical = 16.dp))

            Text(text = "Vous possédez déjà un compte ?")
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                    Text(text = "Se connecter")
                }
            }
        }

        if (viewModel.showLangPicker) {
            SelectLangBottomSheet(viewModel)
        }

        Row() {
            FilledTonalButton(onClick = {
                viewModel.showLangPicker = true
            }, modifier = Modifier.weight(1f)) {
                Icon(
                    painter = painterResource(R.drawable.baseline_language_24),
                    contentDescription = ""
                )
                Text(text = viewModel.getSelectedLang().title, modifier = Modifier.padding(horizontal = 8.dp))
                Icon(
                    painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                    contentDescription = ""
                )
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectLangBottomSheet(viewModel: WelcomePageViewModel) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    ModalBottomSheet(sheetState = sheetState,
        onDismissRequest = {
            viewModel.showLangPicker = false
        },
    ) {
        Surface {
            Column {
                Row(Modifier.fillMaxWidth().padding(start = 32.dp, bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        text = "Choisir une langue", style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                    )
                }

                Divider()

                Column(Modifier.fillMaxWidth()) {
                    viewModel.langs.forEach { lang ->
                        Row(
                            Modifier
                                .selectable(selected = viewModel.selectedLangId == lang.id,
                                onClick = {
                                    viewModel.selectedLangId = lang.id

                                    scope.launch {
                                        delay(300)
                                        sheetState.hide()
                                    }.invokeOnCompletion {
                                        if (!sheetState.isVisible) {
                                            viewModel.showLangPicker = false
                                        }
                                    }
                                })
                                .padding(vertical = 8.dp, horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = viewModel.selectedLangId == lang.id,
                                onClick = { /*TODO*/ })
                            Spacer(modifier = Modifier.width(8.dp))
                            Column(Modifier.weight(1f)) {
                                Text(text = lang.title, style = MaterialTheme.typography.bodyMedium)
                                Text(
                                    text = lang.intTitle, style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.alpha(.7f)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    MyRentTheme {
        WelcomePage()
    }
}