package com.technipixl.and17_exo1.ui.screen

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.technipixl.and17_exo1.LoginUiEvent
import com.technipixl.and17_exo1.LoginUiScreenState
import com.technipixl.and17_exo1.LoginViewModel
import com.technipixl.and17_exo1.R
import com.technipixl.and17_exo1.ui.theme.AND17Exo1Theme
import org.intellij.lang.annotations.JdkConstants.TitledBorderJustification


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAuthentication(
    event: (LoginUiEvent) -> Unit,
    uiState: LoginUiScreenState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        OutlinedTextField(
            value = uiState.login,
            onValueChange = { updatedValue ->
                event(LoginUiEvent.UpdateLogin(updatedValue))
            },
            label = { Text(text = stringResource(R.string.login_title)) },
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp, 4.dp)
        )

        OutlinedTextField(
            value = uiState.password,
            onValueChange = { updatedValue ->
                event(LoginUiEvent.UpdatePassword(updatedValue))
            },
            label = { Text(text = stringResource(R.string.password_title)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp, 4.dp)
        )

        TextButton(onClick = { event(LoginUiEvent.Prefill)},
            content = {
                Text(
                    text = "Pré-remplir mot de passe",
                    color = Color.Black,
                    textAlign = TextAlign.Left
                )
            }
        )

        Row {
            TextButton(onClick = {},
                content = {
                    Text(
                        text = stringResource(R.string.connect_title),
                        color = Color.Black
                    )
                }
            )

            TextButton(onClick = {},
                content = {
                    Text(
                        text = stringResource(R.string.create_account_title),
                        color = Color.Blue
                    )
                }
            )
        }
    }
}

@Composable
@Preview
fun AddAuthenticationPreview() {
    AND17Exo1Theme {
        AddAuthentication(uiState = LoginUiScreenState(), event = {})
    }
}

@Composable
fun LoginRoute(loginViewModel: LoginViewModel = hiltViewModel()) {

   val uiState = loginViewModel.loginUiScreenState.value

    AddAuthentication(
        uiState = uiState,
        event = { loginViewModel.onEvent(it) },
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
    )
}