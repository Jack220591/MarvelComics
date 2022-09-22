package com.ebayula.marvelscomix.presentation.screens.characters.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.magnifier
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ebayula.marvelscomix.presentation.navigation.Screen
import com.ebayula.marvelscomix.presentation.screens.characters.models.CharactersViewState
import com.ebayula.marvelscomix.ui.theme.MarvelHeroesTheme
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersListDisplay(
    modifier: Modifier = Modifier,
    navController: NavController,
    charactersViewState: CharactersViewState.Success
) {
    val listState = rememberLazyListState()

    Surface(modifier = modifier.fillMaxSize()) {
        Box(modifier = modifier.background(MarvelHeroesTheme.colors.primaryBackground)) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                cells = GridCells.Fixed(count = 2),
                state = listState
            ) {
                charactersViewState.data.forEach { cardItem ->
                    item {
                        CharacterCardItem(
                            model = cardItem,
                            onItemClick = { navController.navigate(Screen.CharacterDetails.passCharacterId(cardItem.id ?: 0)) }
                        )
                    }
                }
            }
        }
    }

}