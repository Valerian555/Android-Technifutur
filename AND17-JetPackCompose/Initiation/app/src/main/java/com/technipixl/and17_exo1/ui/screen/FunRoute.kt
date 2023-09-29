package com.technipixl.and17_exo1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.technipixl.and17_exo1.LoginUiEvent
import com.technipixl.and17_exo1.LoginUiScreenState
import com.technipixl.and17_exo1.R
import com.technipixl.and17_exo1.ui.theme.AND17Exo1Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBoxes(
    event: (LoginUiEvent) -> Unit,
    uiState: LoginUiScreenState,
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {

        Box(
        Modifier
            .align(Alignment.TopCenter)
            .fillMaxHeight()
            .width(
                50.dp
            )
            .background(Color.Blue))

        Box(
            Modifier
                .align(Alignment.Center)
                .fillMaxHeight()
                .width(
                    50.dp
                )
                .background(Color.Red))
    }
}


@Composable
@Preview
fun AddBoxesPreview() {
    AND17Exo1Theme {
        AddBoxes(uiState = LoginUiScreenState(), event = {})
    }
}

@Composable
fun FunRoute() {
    Text(text = "Fun Route")
}
