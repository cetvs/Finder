package com.example.finder.feature.auth.presentation.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.finder.common.theme.Pink

@Composable
fun AuthButton(text: String, onClick: (() -> Unit)? = null) {
    Button(
        onClick = onClick ?: {},
        shape = RoundedCornerShape(30),
        colors = ButtonDefaults.buttonColors(backgroundColor = Pink),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            modifier = Modifier.padding(
                top = 16.dp,
                bottom = 16.dp,
            ),
            text = text,
            color = Color.White
        )
    }
}
