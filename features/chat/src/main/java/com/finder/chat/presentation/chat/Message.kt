package com.finder.chat.presentation.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.finder.chat.R
import com.finder.common.formatHHMM
import com.finder.common.theme.Blue
import com.finder.common.theme.Gray
import com.finder.common.theme.PINK_TRANS_12
import com.finder.common.theme.White
import java.util.Date

@Preview
@Composable
private fun MessageBubblePreview() {
    Column(Modifier.background(color = White)) {
        val messageOut = MessageData(
            text = "Hy Jim, I write hello world",
            time = Date(),
            messageType = MessageType.MessageIn,
        )
        Message(messageOut)
        val messageIn = MessageData(
            text = "Ohh.. nice",
            time = Date(),
            messageType = MessageType.MessageOut(true),
        )
        Message(messageIn)
    }
}

@Composable
fun Message(messageData: MessageData) {
    val isOut = messageData.messageType is MessageType.MessageOut
    Row {
        if (isOut) {
            Spacer(modifier = Modifier.weight(1f))
        }
        Column(
            horizontalAlignment = if (isOut) Alignment.End else Alignment.Start
        ) {
            MessageBubble(messageData)
            Row {
                Text(
                    text = messageData.time.formatHHMM()
                )
                if (isOut) {
                    Icon(
                        painter = painterResource(R.drawable.ic_is_viewed),
                        contentDescription = null,
                        modifier = Modifier.absolutePadding(left = 4.dp),
                        tint = Blue,
                    )
                }
            }
        }
        if (!isOut) {
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun MessageBubble(messageData: MessageData) {
    val backgroundColor = if (messageData.messageType is MessageType.MessageOut) {
        Gray
    } else {
        PINK_TRANS_12
    }
    val roundedCorner = 15.dp
    val (leftRoundedCorner, rightRoundedCorner) = if (messageData.messageType is MessageType.MessageOut) {
        Pair(0.dp, roundedCorner)
    } else {
        Pair(roundedCorner, 0.dp)
    }
    Row(
        Modifier
            .clip(
                RoundedCornerShape(
                    roundedCorner,
                    roundedCorner,
                    leftRoundedCorner,
                    rightRoundedCorner
                )
            )
            .background(backgroundColor)
            .padding(all = 10.dp)
    ) {
        Text(text = messageData.text)
    }
}
