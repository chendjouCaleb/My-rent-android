package com.regolia.myrent.identity

import com.regolia.myrent.R

class Channel(val title: String, val image: Int, val id: String) {


    companion object {
        val all = listOf(
            Channel("E-mail", R.drawable.gmail, "email"),
            Channel("Téléphone", R.drawable.telephone_128, "phone"),
            Channel("WhatsApp", R.drawable.whatsapp_128, "whatsapp"),
            Channel("Telegram", R.drawable.telegram_128, "telegram")
        )
    }
}