package com.example.login_application

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginClick = { email, password ->
                    // Handle login logic (to be implemented)
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                },
                onNavigateToPasswordReset = {
                    navController.navigate("password_reset")
                }
            )
        }

        composable("register") {
            RegistrationScreen(
                onRegisterClick = { name, email, password ->
                    // Handle registration logic (to be implemented)
                },
                onNavigateToLogin = {
                    navController.navigate("login")
                }
            )
        }

        composable("password_reset") {
            PasswordResetScreen(
                onResetClick = { email ->
                    // Handle password reset logic (to be implemented)
                },
                onNavigateToLogin = {
                    navController.navigate("login")
                }
            )
        }

        composable("home") {
            HomeScreen()
        }
    }
}
