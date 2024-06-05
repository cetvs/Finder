package com.example.finder.feature.chat.presentation.all_chats

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ChatLazyColumn() {
    LazyColumn {
        items(5) {
            ChatRow()
        }
    }
}