package com.example.login_application

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign

@Composable
fun PasswordResetScreen(
    onResetClick: (String) -> Unit,  // Pass email to the reset handler
    onNavigateToLogin: () -> Unit     // For navigation to login screen
) {
    var email by remember { mutableStateOf("") }
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
            text = "Réinitialiser le mot de passe",
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

        // Reset Button
        Button(
            onClick = {
                if (email.isEmpty()) {
                    showError = true
                    errorMessage = "L'e-mail est requis"
                } else {
                    showError = false
                    onResetClick(email)  // Handle reset logic
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Réinitialiser le mot de passe")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigate to Login
        TextButton(onClick = onNavigateToLogin) {
            Text(text = "Retour à la page connexion")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordResetScreenPreview() {
    PasswordResetScreen(
        onResetClick = {},
        onNavigateToLogin = {}
    )
}
