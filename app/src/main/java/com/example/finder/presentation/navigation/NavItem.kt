package com.example.finder.presentation.navigation

import com.example.finder.R

sealed class NavItem(
    val route: String,
    val icon: Int? = null,
) {
    object Message : NavItem(
        route = "main",
        icon = R.drawable.ic_message
    )

    object ChooseChat : NavItem(
        route = "choose_chat",
    )

    object Profile : NavItem(
        route = "profile",
        icon = R.drawable.ic_profile
    )
}