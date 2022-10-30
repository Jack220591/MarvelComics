package com.jack.marvelscomics.presentation.screens.characters.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jack.marvelscomics.presentation.navigation.NavigationDestination
import com.jack.marvelscomics.presentation.screens.characters.CharactersRoute

object CharactersDestination : NavigationDestination {
    override val route = "characters_route"
    override val destination = "characters_destination"
}

@OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalMaterialApi::class
)
fun NavGraphBuilder.charactersGraph() {
    composable(route = CharactersDestination.route) {
        CharactersRoute()
    }
}