package com.regolia.myrent.pages.identity

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import java.lang.StringBuilder

data class Country(val code: String, val phoneCode: String)

class CountryList {
    companion object {
        fun codeToFlag(cod: String): String {
            val code = cod.toUpperCase(Locale.current)
            val builder = StringBuilder()
            for (c in code) {
                builder.appendCodePoint(c.code + 127397)
            }
            return builder.toString()
        }
        val list = listOf(
            Country("af", "93"),
            Country("al", "355"),
            Country("dz", "213"),
            Country("as", "1-684"),
            Country("ad", "376"),
            Country("ao", "244"),
            Country("ai", "1-264"),
            Country("aq", "672"),
            Country("ag", "1-268"),
            Country("54", "ar"),
            Country("am", "374"),
            Country("aw", "297"),
            Country("au", "61"),
            Country("43", "at"),
            Country("az", "994"),
            Country("bs", "1-242"),
            Country("cm", "237"),
        )
    }
}