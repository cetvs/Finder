package com.example.finder.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finder.feature.chat.presentation.AllChatsScreen
import com.example.finder.feature.profile.ProfileScreen

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Message.route
    ) {
        composable(route = NavItem.Message.route) {
            AllChatsScreen()
        }
        composable(route = NavItem.Profile.route) {
            ProfileScreen()
        }
    }
}