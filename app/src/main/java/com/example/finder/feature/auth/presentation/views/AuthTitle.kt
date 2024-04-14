package com.example.finder.feature.auth.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AuthTitle(title: String, subtitle: String? = null) {
    Column() {
        Text(
            text = title,
            modifier = Modifier.padding(),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h1
        )
        if (subtitle != null) {
            Text(
                text = subtitle,
                modifier = Modifier.padding(
                    top = 10.dp,
                ),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}