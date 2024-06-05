package com.example.finder.feature.chat.presentation.chat_with_user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.finder.R
import com.example.finder.feature.chat.presentation.ChatViewModel
import com.example.finder.presentation.theme.LightGray
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChatUserWithUserScreen() {
    Column {
        ChatHeader()
        MessagesBody()
    }
}

@Composable
private fun ChatHeader() {
    Row {
        Icon(
            painterResource(id = R.drawable.search),
            contentDescription = null,
        )
    }
    Divider(color = LightGray, thickness = 1.dp)
}

@Composable
private fun MessagesList() {
//    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
            item {
                Text(text = "пустой текст")
            }
        }
//    }
}

@Composable
private fun MessagesBody() {
    MessagesList()
    Divider(color = LightGray, thickness = 1.dp)
    Row {
        MessageTextField()
    }
}


@Composable
fun MessageTextField() {
    var text by remember { mutableStateOf("") }
    val chatViewModel: ChatViewModel = koinViewModel()

    Row {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Введите текст") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
        Button(onClick = {}){
            Icon(
                painterResource(id = R.drawable.search),
                contentDescription = null,
            )
        }
    }
}