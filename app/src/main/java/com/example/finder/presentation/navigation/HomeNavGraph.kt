package com.example.finder.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finder.feature.chat.presentation.all_chats.AllChatsScreen
import com.example.finder.feature.chat.presentation.chat_with_user.ChatUserWithUserScreen
import com.example.finder.feature.profile.ProfileScreen

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItem.ChooseChat.route
    ) {
        composable(route = NavItem.Message.route) {
            AllChatsScreen()
        }
        composable(route = NavItem.ChooseChat.route) {
            ChatUserWithUserScreen()
        }
        composable(route = NavItem.Profile.route) {
            ProfileScreen()
        }
    }
}