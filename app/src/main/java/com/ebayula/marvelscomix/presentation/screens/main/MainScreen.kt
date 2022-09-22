package com.ebayula.marvelscomix.presentation.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ebayula.marvelscomix.presentation.navigation.charactersFlow
import com.ebayula.marvelscomix.presentation.screens.main.navigation.MainBottomScreen
import com.ebayula.marvelscomix.ui.theme.MarvelHeroesTheme

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun MainScreen(
    navController: NavController
) {
    val childNavController = rememberNavController()

    val items = listOf(
        MainBottomScreen.Characters,
        MainBottomScreen.Comics
    )

    Column {
        Box(modifier = Modifier.weight(1f)) {
            NavHost(
                navController = childNavController,
                startDestination = MainBottomScreen.Characters.route
            ) {

                charactersFlow(navController = childNavController)
            }
        }

        Box(
            modifier = Modifier

                .fillMaxWidth()
        ) {

            NavigationBar() {
                val navBackStackEntry by childNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                val previousDestination = remember { mutableStateOf(items.first().route) }

                items.forEach { screen ->
                    val isSelected = currentDestination?.hierarchy
                        ?.any { it.route == screen.route } == true

                    NavigationBarItem(
                        modifier = Modifier.background(MarvelHeroesTheme.colors.navBarBackground),
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MarvelHeroesTheme.colors.indicatorsColor,
                        ),
                        icon = {
                            Icon(
                                imageVector = when (screen) {
                                    MainBottomScreen.Characters -> Icons.Filled.Face
                                    MainBottomScreen.Comics -> Icons.Filled.Star
                                },
                                contentDescription = null,
                                tint = if (isSelected) Color.White else MarvelHeroesTheme.colors.secondaryText
                            )
                        },
                        label = {
                            Text(
                                stringResource(id = screen.resourceId),
                                style = MarvelHeroesTheme.typography.caption,
                                color = if (isSelected) MarvelHeroesTheme.colors.primaryText else MarvelHeroesTheme.colors.secondaryText
                            )
                        },
                        selected = isSelected,
                        onClick = {
                            if (screen.route == previousDestination.value) return@NavigationBarItem
                            previousDestination.value = screen.route

                            childNavController.navigate(screen.route) {
                                popUpTo(childNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        }
    }

}