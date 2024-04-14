package com.example.finder.feature.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finder.R
import com.example.finder.feature.auth.presentation.views.AuthButton
import com.example.finder.feature.auth.presentation.views.AuthTitle

@Composable
fun AuthHost() {
    StartRegisterScreen()
}

@Preview
@Composable
fun StartRegisterScreen() {
    Column(
        modifier = Modifier.padding(
            start = 20.dp,
            top = 64.dp,
            end = 20.dp,
            bottom = 24.dp,
        )
    ) {
        AuthTitle(
            title = stringResource(R.string.phone_number_title),
            subtitle = stringResource(R.string.phone_number_subtitle)
        )
        Spacer(modifier = Modifier.weight(1f))
        AuthButton(
            text = stringResource(R.string.bottom_button)
        )
    }
}