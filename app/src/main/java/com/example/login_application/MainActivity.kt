package com.example.login_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.login_application.ui.theme.LoginApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    val navController = rememberNavController()
                    NavGraph(navController)
                }
            }
        }
    }
}
