package com.example.login_application

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit,  // Pass email and password to the login handler
    onNavigateToRegister: () -> Unit,        // For navigation to registration screen
    onNavigateToPasswordReset: () -> Unit    // For navigation to password reset screen
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Email Input
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = showError && email.isEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Input
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = showError && password.isEmpty()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Error Message
        if (showError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {
                if (email.isEmpty() || password.isEmpty()) {
                    showError = true
                    errorMessage = "L'e-mail et le mot de passe sont requis"
                } else {
                    showError = false
                    onLoginClick(email, password)  // Handle login logic
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Se connecter")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigate to Registration
        TextButton(onClick = onNavigateToRegister) {
            Text(text = "Vous n'avez pas de compte ? Registre")
        }

        // Navigate to Password Reset
        TextButton(onClick = onNavigateToPasswordReset) {
            Text(text = "Mot de passe oublié ?")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginClick = { _, _ -> },
        onNavigateToRegister = {},
        onNavigateToPasswordReset = {}
    )
}
