package com.example.apisomething

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apisomething.ui.screens.LoginScreen
import com.example.apisomething.ui.screens.RegisterScreen
import com.example.apisomething.vm.AuthViewModel

object Routes{
    const val LOGIN = "login"
    const val REGISTER= "register"
    const val USERS= "users"
    const val EDIT= "edit"
}

@Composable
fun AppNav(
    authVm : AuthViewModel
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
         LoginScreen(
             vm = authVm,
             onLoginSucces = {
                 nav.navigate(Routes.USERS){
                     popUpTo(Routes.LOGIN){inclusive = true}
                 }
             },
             onGoRegister = {
                 nav.navigate(Routes.REGISTER)
             }
         )
     }
        composable(Routes.REGISTER)
        {
            RegisterScreen(
                vm = authVm,
                onRegisterSuccess = {
                    nav.popBackStack()
                },
                onBack = {
                    nav.popBackStack()
                }
            )
        }
    }
}