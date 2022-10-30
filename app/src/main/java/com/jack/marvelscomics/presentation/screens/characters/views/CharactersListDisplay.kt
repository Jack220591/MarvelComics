package com.jack.marvelscomics.presentation.screens.characters.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jack.marvelscomics.presentation.screens.characters.models.CharactersViewState


@Composable
fun CharactersListDisplay(
    modifier: Modifier = Modifier,
    onDetailsRoute: () -> Unit,
    charactersViewState: CharactersViewState.Success
) {
    val listState = rememberLazyGridState()

    Surface(modifier = modifier.fillMaxSize()) {
        Box {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(count = 2),
                state = listState
            ) {
                charactersViewState.data.forEach { cardItem ->
                    item {
                        CharacterCardItem(
                            model = cardItem,
                            onItemClick = {
                                //navController.navigate(Screen.CharacterDetails.passCharacterId(cardItem.id ?: 0))
                                onDetailsRoute()
                            }
                        )
                    }
                }
            }
        }
    }

}