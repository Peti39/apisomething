package com.example.apisomething.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apisomething.data.CreateUserRequest
import com.example.apisomething.data.UsersApi
import com.example.apisomething.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private  val api: UsersApi
): ViewModel() {

    private val _loginState = MutableStateFlow<UiState<Unit>>(UiState.Idle)

    val loginState: StateFlow<UiState<Unit>> = _loginState

    private val _registerState = MutableStateFlow<UiState<Unit>>(UiState.Idle)

    val registerState: StateFlow<UiState<Unit>> = _registerState

    fun login(email: String, password: String, onSucces: ()-> Unit){
        if(email.isBlank() || password.isBlank()){
            _loginState.value = UiState.Error("Adj meg email és jelszót")
            return
        }

        _loginState.value = UiState.Idle

        viewModelScope.launch {
            try {
                val users = api.getUsers()

                val ok = users.any {
                    it.email.equals(email, ignoreCase = true)&&
                            it.password == password
                }

                if (ok){
                    _loginState.value = UiState.Data(Unit)
                }else{
                    _loginState.value = UiState.Error("Hibás email vagy jelszó")
                }
            }catch (t: Throwable){
                _loginState.value = UiState.Error(t.message ?: "Hálózati hiba")

            }
        }
    }

    fun register(
        name: String,
        email: String,
        password: String,
        birthdate: String,
        onSucces: () -> Unit
    ){
        if(name.isBlank()||email.isBlank()||password.isBlank()||birthdate.isBlank()){
            _registerState.value = UiState.Error(">:(")
            return
        }

        _registerState.value = UiState.Loading
        viewModelScope.launch {
            try {
                api.createUser(
                    CreateUserRequest(
                        name = name,
                        email = email,
                        password = password,
                        birthDate = birthdate
                    )
                )
                _registerState.value = UiState.Data(Unit)
                onSucces()
            }catch (t: Throwable){
                _registerState.value = UiState.Error(t.message?:"Hálózati hiba")
            }
        }
    }
}
