package com.jack.marvelscomics.presentation.screens.characters.character_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.jack.marvelscomics.presentation.screens.characters.models.CharactersViewState
import com.jack.marvelscomics.presentation.screens.characters.views.*

@Composable
fun CharacterDetailsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    characterDetailsViewModel: CharacterDetailsViewModel,
    characterId: Int
) {

    val viewState = characterDetailsViewModel.charactersViewState.collectAsState()

    val state = viewState.value
    val character = if (state is CharactersViewState.Success) {
        state.data.firstOrNull()
    } else null

    Scaffold(
        /*topBar = {
            NavigationTopBar(character?.name ?: "", navController)
        },*/
        content = {
            Column(Modifier
                    .verticalScroll(rememberScrollState())) {
                when (state) {
                    CharactersViewState.Loading -> ViewLoading()
                    CharactersViewState.Error -> CharactersViewError {
                        characterDetailsViewModel.fetchCharactersById(characterId = characterId)
                    }
                    is CharactersViewState.Success -> {
                        state.data.forEach {
                            CharacterDetailsContent(character = it)
                        }
                    }
                    CharactersViewState.NoneData -> CharacterViewNoItems()
                }

                CharacterComicsView(
                    navController = navController,
                    viewModel = characterDetailsViewModel,
                    characterId = characterId
                )
            }

        }
    )

    LaunchedEffect(key1 = viewState, block = {
        characterDetailsViewModel.fetchCharactersById(characterId = characterId)
    })


}