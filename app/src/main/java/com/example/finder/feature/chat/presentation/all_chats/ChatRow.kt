package com.example.finder.feature.chat.presentation.all_chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finder.R
import com.example.finder.presentation.theme.Blue
import com.example.finder.presentation.theme.LightGray
import com.example.finder.presentation.theme.SwipeGray

@Preview
@Composable
fun ChatRow() {
    Row {
        Image(
            painter = painterResource(R.drawable.ic_test),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Виктория"
            )
            Text(
                text = "Стикер",
                color = SwipeGray,
            )
        }
        Column {
            Text(
                text = "23 мин",
                color = SwipeGray,
            )
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .drawBehind {
                        drawCircle(
                            color = Blue,
                            radius = 40F
                        )
                    },
                text = "2",
                color = Color.White,
            )
        }
    }
    Divider(color = LightGray, thickness = 1.dp)
}