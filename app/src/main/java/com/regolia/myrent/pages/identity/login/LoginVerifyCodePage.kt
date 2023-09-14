package com.regolia.myrent.pages.identity.login

import androidx.compose.runtime.Composable
import com.regolia.myrent.pages.identity.shared.VerifyEmailPage
import com.regolia.myrent.pages.identity.shared.VerifyWhatsAppPage


@Composable
fun LoginVerifyCodePage(viewModel: LoginPageViewModel) {

    if(viewModel.selectedChannel.id == "email") {
        VerifyEmailPage(email = viewModel.userId)
    }else if(viewModel.selectedChannel.id == "whatsapp"){
        VerifyWhatsAppPage(email = viewModel.userId)
    }

}