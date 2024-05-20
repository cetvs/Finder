package com.example.finder.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.finder.presentation.theme.Pink

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun BottomBar() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                listOf(
                    NavItem.Message,
                    NavItem.Profile
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        HomeNavGraph(navController)
    }
}

@Composable
fun BottomNavigationBar(
    items: List<NavItem>,
    navController: NavHostController,
    onItemClick: (NavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry.value?.destination

    val screens = listOf(
        NavItem.Message,
        NavItem.Profile,
    )
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation(
            elevation = 5.dp,
            backgroundColor = Color.White
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    icon = {
                        Icon(
                            painterResource(id = item.icon!!),
                            contentDescription = null,
                        )
                    },
                    selectedContentColor = Pink,
                    unselectedContentColor = Color.Gray,
                )
            }
        }
    }
}