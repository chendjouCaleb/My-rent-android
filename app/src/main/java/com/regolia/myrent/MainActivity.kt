package com.regolia.myrent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.livedata.observeAsState
import com.regolia.myrent.identity.services.AuthenticationService
import com.regolia.myrent.ui.theme.MyRentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRentTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    var authState = AuthenticationService.instance().isInitState.observeAsState(false)
                    if(authState.value) {
                        MainNavGraph()
                    }else {
                        LoadingPage()
                    }

                    //CountryListPicker()
                }

            }
        }
    }
}
