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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apisomething.ui.UiState
import com.example.apisomething.vm.AuthViewModel

@Composable
fun RegisterScreen(
    vm: AuthViewModel,
    onRegisterSuccess: () -> Unit,
    onBack: () -> Unit
){
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val birthdate = remember { mutableStateOf("") }

    val state = vm.registerState.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Regisztráció")

        OutlinedTextField(value = name.value, onValueChange = {
            name.value = it
            //Error
        }, label = {Text("Név")})
        OutlinedTextField(value = email.value, onValueChange = {
            email.value = it
            //Error
        }, label = {Text("Email")})
        OutlinedTextField(value = password.value, onValueChange = {
            password.value = it
            //Error
        }, label = {Text("Jelszó")})
        OutlinedTextField(value = birthdate.value, onValueChange = {
            birthdate.value = it
            //Error
        }, label = {Text("Születési idő")})

        when(state){
            UiState.Loading -> CircularProgressIndicator()
            is UiState.Error -> Text("Hibe ${state.message}")
            else -> Unit
        }

        Button(
            onClick = {
                vm.register(name.value,email.value,password.value,birthdate.value, onRegisterSuccess)
            }
        ) { Text("Regisztáció")}

        OutlinedButton(onClick = onBack) { Text("Vissza") }



    }
}