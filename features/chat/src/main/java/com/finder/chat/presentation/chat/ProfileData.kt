package com.finder.chat.presentation.chat

import java.util.Date

data class ProfileData(val icon: Int, val name: String, val connectStatus: ConnectStatus)
sealed class ConnectStatus {
    data class Offline(val lastSeen: Date) : ConnectStatus()
    object Online : ConnectStatus()
}
