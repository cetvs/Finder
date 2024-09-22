package com.finder.chat.presentation.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finder.chat.R
import com.finder.common.formatHHMM
import com.finder.common.theme.Black40
import com.finder.common.theme.GreenOnline
import org.koin.androidx.compose.koinViewModel

@Composable
fun Chat() {
//    val chatViewModel: ChatViewModel by viewModel()



    val mockProfileData = ProfileData(
        icon = R.drawable.preview_user_image,
        name = "Соня",
        connectStatus = ConnectStatus.Online,
    )
    Column {
        ChatHeader(mockProfileData)
        MessagesBody()
    }
}

@Preview
@Composable
fun ChatHeaderPreview() {
    val profileData = ProfileData(
        icon = R.drawable.preview_user_image,
        name = "Соня",
        connectStatus = ConnectStatus.Online,
    )
    ChatHeader(profileData)
}


@Composable
private fun ChatHeader(profileData: ProfileData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(64.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp)
                .clip(CircleShape)
                .clickable { },
            contentDescription = null,
        )
        Image(
            painter = painterResource(id = R.drawable.preview_user_image),
            modifier = Modifier
                .padding(start = 16.dp)
                .size(48.dp),
            contentDescription = null,
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp),
        ) {
            Text(
                text = profileData.name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val connectStatusText = if (profileData.connectStatus is ConnectStatus.Offline) {
                    stringResource(id = R.string.offline_prefix) + profileData.connectStatus.lastSeen.formatHHMM()
                } else {
                    stringResource(id = R.string.online)
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_online),
                    contentDescription = null,
                    tint = GreenOnline
                )
                Text(
                    text = connectStatusText,
                    modifier = Modifier.padding(start = 4.dp, bottom = 2.dp),
                    fontSize = 12.sp,
                    color = Black40
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_additional_profile_info),
            modifier = Modifier
                .padding(end = 16.dp)
                .size(24.dp)
                .clip(CircleShape)
                .clickable { },
            contentDescription = null,
        )
    }
    Divider(color = LightGray, thickness = 1.dp)
}

@Composable
private fun MessagesList() {
    val message by koinViewModel<ChatViewModel>().messages.collectAsState()
    LazyColumn() {
        item {
            Text(text = message?.content ?: "")
        }
    }
}

@Composable
private fun MessagesBody() {
    Column {
        MessagesList()
        Spacer(modifier = Modifier.weight(1f))
        Divider(color = LightGray, thickness = 1.dp)
        Row {
            SendMessageBar()
//            MessageTextField()
        }
    }
}
