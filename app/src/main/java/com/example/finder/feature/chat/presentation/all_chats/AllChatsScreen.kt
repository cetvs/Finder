package com.example.finder.feature.chat.presentation.all_chats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finder.R
import com.example.finder.presentation.theme.LightGray

@Composable
fun AllChatsScreen() {
    Column {
        Row(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 22.dp,
                bottom = 22.dp,
                end = 16.dp,
            )
        ) {
            Text(
                text = stringResource(R.string.all_chats_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painterResource(id = R.drawable.search),
                contentDescription = null,
            )
        }
        Divider(color = LightGray, thickness = 1.dp)
        ChatLazyColumn()
    }
}