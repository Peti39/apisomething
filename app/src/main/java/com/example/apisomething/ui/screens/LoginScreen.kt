package com.example.apisomething.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apisomething.ui.UiState


@Composable
fun LoginScreen(
    //TODO: view
){
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        Text("Bejelentkezés")

        OutlinedTextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            label = {Text("asd")},
            singleLine = true
        )

        OutlinedTextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            label = {Text("asd")},
            singleLine = true
        )

        /*
        when(state){
            UiState.Loading -> CircularProgressIndicator()
            is UiState.Error -> Text("Hiba ${state.message}")
            else -> Unit
        }

         */

        Button(
            onClick = {}
        ) {
            Text("Belépés")

        }
        OutlinedButton(
            onClick = {}
        ) {
            Text("Regisztráció")
        }

    }
}

