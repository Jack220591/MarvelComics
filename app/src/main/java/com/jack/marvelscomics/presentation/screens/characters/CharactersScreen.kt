package com.jack.marvelscomics.presentation.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.jack.marvelscomics.presentation.screens.characters.models.CharactersViewState
import com.jack.marvelscomics.presentation.screens.characters.views.CharacterViewNoItems
import com.jack.marvelscomics.presentation.screens.characters.views.CharactersListDisplay
import com.jack.marvelscomics.presentation.screens.characters.views.CharactersViewError
import com.jack.marvelscomics.presentation.screens.characters.views.ViewLoading

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun CharactersRoute(
    modifier: Modifier = Modifier,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val viewState by viewModel.charactersCharactersViewState.collectAsState()
    CharactersScreen(
        modifier = modifier,
        charactersViewState = viewState,
        onFetchCharacters = viewModel::fetchCharacters,
        onDetailsRoute = { }
    )
}

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    charactersViewState: CharactersViewState,
    onFetchCharacters: () -> Unit,
    onDetailsRoute: () -> Unit
) {
    var initialApiCalled by rememberSaveable { mutableStateOf(false) }
    //val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }

    Scaffold(
       // modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        /*topBar = {
            TopBar()
        },*/
        content = {
            when (charactersViewState) {
                CharactersViewState.Loading -> ViewLoading()
                CharactersViewState.Error -> CharactersViewError { onFetchCharacters() }
                is CharactersViewState.Success -> CharactersListDisplay(
                    modifier = modifier,
                    onDetailsRoute = onDetailsRoute,
                    charactersViewState = charactersViewState
                )
                CharactersViewState.NoneData -> CharacterViewNoItems()
            }
        }
    )

    if (!initialApiCalled) {
        LaunchedEffect(key1 = Unit, block = {
            onFetchCharacters()
            initialApiCalled = true
        })
    }

}