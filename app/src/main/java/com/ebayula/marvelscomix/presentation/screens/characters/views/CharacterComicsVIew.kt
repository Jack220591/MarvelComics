package com.ebayula.marvelscomix.presentation.screens.characters.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Surface
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ebayula.marvelscomix.R
import com.ebayula.marvelscomix.presentation.screens.characters.character_details.CharacterDetailsViewModel
import com.ebayula.marvelscomix.presentation.screens.characters.models.ComicsViewState
import com.ebayula.marvelscomix.ui.theme.MarvelHeroesTheme


@Composable
fun CharacterComicsView(
    navController: NavController,
    viewModel: CharacterDetailsViewModel,
    characterId: Int
) {

    val comicsViewState = viewModel.comicsViewState.collectAsState()

    when(val comicState = comicsViewState.value) {
        ComicsViewState.Loading -> {
            Box(modifier = Modifier.fillMaxWidth()) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(24.dp)
                        .align(alignment = Alignment.Center),
                    color = MarvelHeroesTheme.colors.tintColor,
                    strokeWidth = 2.dp
                )
            }

        }
        ComicsViewState.Error -> {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.Center)
                        .padding(horizontal = 16.dp),
                    text = stringResource(id = R.string.error_loading_comics),
                    style = MarvelHeroesTheme.typography.body,
                    color = MarvelHeroesTheme.colors.secondaryText
                )
            }

        }
        is ComicsViewState.Success -> {
            val items = comicState.data

            Column(Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(R.string.comics_bottom_navigation_title),
                    style = MarvelHeroesTheme.typography.heading,
                    color = MarvelHeroesTheme.colors.secondaryText,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
                )

                LazyRow (
                    contentPadding = PaddingValues(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxWidth().height(320.dp)
                ) {
                    items.forEach { comic ->
                        item {
                            ComicCardItem(
                                model = comic,
                                onItemClick = {}
                            )
                        }
                    }
                }
            }

        }
        ComicsViewState.NoneData -> {}
    }


    LaunchedEffect(key1 = comicsViewState, block = {
        viewModel.fetchComics(characterId = characterId)
    })

}