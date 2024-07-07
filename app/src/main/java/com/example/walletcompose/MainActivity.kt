package com.example.walletcompose

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.walletcompose.ui.LoginScreen
import com.example.walletcompose.ui.OnBoardingScreen
import com.example.walletcompose.ui.SplashScreenWpay
import com.example.walletcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            WalletComposeTheme {
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
//                    SplashScreenWpay()
//                    OnBoardingScreen()
//                }
//            }

            WalletComposeTheme2 {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
                    LoginScreen()
                }
            }
        }
    }
}

