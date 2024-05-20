package com.example.finder.feature.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finder.R
import com.example.finder.feature.auth.presentation.views.AuthButton
import com.example.finder.feature.auth.presentation.views.AuthTitle
import com.example.finder.feature.auth.presentation.views.PhoneTextField
import org.koin.androidx.compose.koinViewModel

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
        val authViewModel = koinViewModel<AuthViewModel>()
        AuthTitle(
            title = stringResource(R.string.phone_number_title),
            subtitle = stringResource(R.string.phone_number_subtitle)
        )
        var phoneText by remember { mutableStateOf("") }
        PhoneTextField(text = phoneText) {
            phoneText = it
        }
        Spacer(modifier = Modifier.weight(1f))
        AuthButton(
            text = stringResource(R.string.bottom_button),
            onClick = {
//                if (isValidPhoneNumber(phoneText)) {
                    authViewModel.registerUser(phoneText)
//                }
            }
        )
    }
}

fun isValidPhoneNumber(phoneNumber: String): Boolean {
    return phoneNumber.length == 10
}