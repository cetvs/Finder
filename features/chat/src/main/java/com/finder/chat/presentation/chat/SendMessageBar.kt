package com.finder.chat.presentation.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.finder.chat.R
import com.finder.common.theme.White

@Preview
@Composable
fun SendMessageBarPreview() {
    Column(Modifier.background(color = White)) {
        SendMessageBar()
    }
}

@Composable
fun SendMessageBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_paperclip),
            contentDescription = null,
        )
        MessageField()
        Icon(
            painter = painterResource(id = R.drawable.ic_smile),
            modifier = Modifier.padding(end = 16.dp),
            contentDescription = null,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_send),
            contentDescription = null,
        )
    }
}

@Composable
fun MessageField() {
    var messageText by remember { mutableStateOf("") }

    TextField(
        value = messageText,
        onValueChange = {
            messageText = it
        },
        label = {
            Text(text = "Введите текст")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}
