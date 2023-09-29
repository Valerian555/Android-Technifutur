package com.technipixl.and17_exo1

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private var _loginUiScreenState = mutableStateOf(LoginUiScreenState())
    val loginUiScreenState: State<LoginUiScreenState> = _loginUiScreenState

    fun onEvent(event: LoginUiEvent) {
        when (event) {
            LoginUiEvent.Login -> {
                //Make your network call
            }

            is LoginUiEvent.UpdateLogin -> {
                _loginUiScreenState.value = _loginUiScreenState.value.copy(
                    login = event.login
                )
            }

            is LoginUiEvent.UpdatePassword -> {
                _loginUiScreenState.value = _loginUiScreenState.value.copy(
                    password = event.password
                )
            }

            LoginUiEvent.Prefill -> {
                _loginUiScreenState.value = _loginUiScreenState.value.copy(
                    password = "prefilled password"
                )
            }
        }
    }
}

sealed class LoginUiEvent {
    data class UpdateLogin(val login: String) : LoginUiEvent()
    data class UpdatePassword(val password: String) : LoginUiEvent()
    object  Prefill: LoginUiEvent()
    object Login : LoginUiEvent()
}

data class LoginUiScreenState(
    val login: String = "",
    val password: String = ""
)