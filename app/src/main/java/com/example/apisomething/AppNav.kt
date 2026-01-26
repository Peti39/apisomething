package com.example.apisomething

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apisomething.ui.screens.LoginScreen

object Routes{
    const val LOGIN = "login"
    const val REGISTER= "register"
    const val USERS= "users"
    const val EDIT= "edit"
}

@Composable
fun AppNav(

)
{
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = Routes.LOGIN
    )
    {
     composable(Routes.LOGIN)
     {
         LoginScreen()
     }
    }
}