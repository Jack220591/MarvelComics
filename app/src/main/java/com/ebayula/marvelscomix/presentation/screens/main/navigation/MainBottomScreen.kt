package com.ebayula.marvelscomix.presentation.screens.main.navigation

import androidx.annotation.StringRes
import com.ebayula.marvelscomix.R

sealed class MainBottomScreen(val route: String, @StringRes val resourceId: Int) {
    object Characters : MainBottomScreen("charactersFlow", R.string.characters_bottom_navigation_title)
    object Comics : MainBottomScreen("comicsFlow", R.string.comics_bottom_navigation_title)
}