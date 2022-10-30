package com.jack.marvelscomics.presentation.navigation

import com.jack.marvelscomics.ui.theme.Icon


data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int
) : NavigationDestination