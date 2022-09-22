package com.ebayula.marvelscomix.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ebayula.marvelscomix.Constans
import com.ebayula.marvelscomix.presentation.screens.characters.CharactersScreen
import com.ebayula.marvelscomix.presentation.screens.characters.CharactersViewModel
import com.ebayula.marvelscomix.presentation.screens.characters.character_details.CharacterDetailsScreen
import com.ebayula.marvelscomix.presentation.screens.characters.character_details.CharacterDetailsViewModel
import com.ebayula.marvelscomix.presentation.screens.main.navigation.MainBottomScreen

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
fun NavGraphBuilder.charactersFlow(
    navController: NavController,
) {
    navigation(startDestination = "characters", route = MainBottomScreen.Characters.route) {
        composable(Screen.Characters.route) {
            val charactersViewModel = hiltViewModel<CharactersViewModel>()
            CharactersScreen(
                navController = navController,
                charactersViewModel = charactersViewModel
            )
        }
        composable(
            route = Screen.CharacterDetails.route,
            arguments = listOf(navArgument(Constans.CHARACTER_DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt(Constans.CHARACTER_DETAILS_ARGUMENT_KEY)
                ?.let {
                    val characterDetailsViewModel = hiltViewModel<CharacterDetailsViewModel>()
                    CharacterDetailsScreen(
                        navController = navController,
                        characterDetailsViewModel = characterDetailsViewModel,
                        characterId = it
                    )
                }

        }
    }
}