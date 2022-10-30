package com.jack.marvelscomics.presentation.screens.comics.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jack.marvelscomics.presentation.navigation.NavigationDestination
import com.jack.marvelscomics.presentation.screens.comics.ComicsRoute

object ComicsDestination : NavigationDestination {
    override val route = "comics_route"
    override val destination = "comics_destination"
}

@OptIn(
    ExperimentalFoundationApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalMaterialApi::class
)
fun NavGraphBuilder.comicsGraph() {
    composable(route = ComicsDestination.route) {
        ComicsRoute()
    }
}