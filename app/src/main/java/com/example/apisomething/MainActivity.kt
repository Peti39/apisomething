package com.example.apisomething

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apisomething.data.RetrofitProvider
import com.example.apisomething.data.UsersApi
import com.example.apisomething.ui.theme.ApisomethingTheme
import com.example.apisomething.vm.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val retrofit = RetrofitProvider.create()
        val api = retrofit.create(UsersApi::class.java)

        val authVm = AuthViewModel(api)
        setContent {
            ApisomethingTheme {
                AppNav(authVm = authVm)

            }
        }
    }
}
