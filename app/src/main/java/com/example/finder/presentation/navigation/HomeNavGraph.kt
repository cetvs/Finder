package com.example.finder.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finder.feature.profile.ProfileScreen
import com.finder.chat.presentation.all_chats.AllChatsScreen
import com.finder.chat.presentation.chat.Chat

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
             Chat()
        }
        composable(route = NavItem.Profile.route) {
            ProfileScreen()
        }
    }
}
