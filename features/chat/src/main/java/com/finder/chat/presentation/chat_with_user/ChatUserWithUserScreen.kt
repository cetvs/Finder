package com.finder.chat.presentation.chat_with_user

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.finder.feature.chat.presentation.ChatViewModel
import com.finder.chat.R
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

    val message by koinViewModel<ChatViewModel>().messages.collectAsState()
    LazyColumn() {
        item {
            Text(text = message?.content ?: "")
        }
    }
//    val messages by koinViewModel<ChatViewModel>().messages.collectAsState()
//    LazyColumn(modifier = Modifier.fillMaxSize()) {
//        items(messages) { message ->
//            MessageItem(message = message) // Ваш composable для отображения сообщения
//        }
//    }
//    }
}

@Composable
private fun MessageItem(message: Int) {

}

@Composable
private fun MessagesBody() {
    Column {
        MessagesList()
        Spacer(modifier = Modifier.weight(1f))
        Divider(color = LightGray, thickness = 1.dp)
        Row {
            MessageTextField()
        }
    }
}

@Composable
fun MessageTextField() {
    var messageText by remember { mutableStateOf("") }
    val chatViewModel: ChatViewModel = koinViewModel()

    Row {
        TextField(
            value = messageText,
            onValueChange = { messageText = it },
            label = { Text("Введите текст") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
        Button(onClick = { chatViewModel.sendMessage(messageText) }) {
            Icon(
                painterResource(id = R.drawable.search),
                contentDescription = null,
            )
        }
    }
}
