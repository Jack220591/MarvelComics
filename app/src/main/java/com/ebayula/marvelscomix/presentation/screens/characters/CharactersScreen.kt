package com.ebayula.marvelscomix.presentation.screens.characters

import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.ebayula.marvelscomix.presentation.screens.characters.models.CharactersViewState
import com.ebayula.marvelscomix.presentation.screens.characters.views.CharacterViewNoItems
import com.ebayula.marvelscomix.presentation.screens.characters.views.CharactersListDisplay
import com.ebayula.marvelscomix.presentation.screens.characters.views.CharactersViewError
import com.ebayula.marvelscomix.presentation.screens.characters.views.ViewLoading
import com.ebayula.marvelscomix.ui.common_components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    charactersViewModel: CharactersViewModel
) {

    val viewState = charactersViewModel.charactersCharactersViewState.collectAsState()
    var initialApiCalled by rememberSaveable { mutableStateOf(false) }
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar()
        },
        content = {
            when (val state = viewState.value) {
                CharactersViewState.Loading -> ViewLoading()
                CharactersViewState.Error -> CharactersViewError { charactersViewModel.fetchCharacters() }
                is CharactersViewState.Success -> CharactersListDisplay(
                    modifier = modifier,
                    navController = navController,
                    charactersViewState = state
                )
                CharactersViewState.NoneData -> CharacterViewNoItems()
            }
        }
    )

    if (!initialApiCalled) {
        LaunchedEffect(key1 = Unit, block = {
            charactersViewModel.fetchCharacters()
            initialApiCalled = true
        })
    }

}