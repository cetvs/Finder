package com.example.finder.feature.auth.presentation.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun PhoneTextField(text: String, onValueChange: (String) -> Unit) {
    Row {
//        Text(text = "+7")
//        Box(modifier = Modifier
//            .size(1.dp, 16.dp)
//            .padding(1))
        TextField(
            modifier = Modifier.padding(
                top = 30.dp
            ),
            value = text,
            onValueChange = onValueChange,
            textStyle = TextStyle.Default
        )
    }
}