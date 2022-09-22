package com.ebayula.marvelscomix.presentation.screens.characters.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.ebayula.marvelscomix.domain.models.MarvelCharacter
import com.ebayula.marvelscomix.ui.theme.MarvelHeroesTheme

@Composable
fun CharacterDetailsContent(
    character: MarvelCharacter
) {
    val scrollState = rememberScrollState()

    Card(
        elevation = 0.dp,
        shape = MarvelHeroesTheme.shapes.cornersStyle
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MarvelHeroesTheme.colors.primaryBackground)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = character.thumbnail?.path + "." + character.thumbnail?.extension,
                    builder = {
                        crossfade(true)
                        scale(Scale.FIT)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier.padding(4.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                character.name?.let {
                    Text(
                        text = it,
                        style = MarvelHeroesTheme.typography.heading,
                        color = MarvelHeroesTheme.colors.primaryText
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                character.description?.let {
                    Text(
                        text = it,
                        style = MarvelHeroesTheme.typography.body,
                        color = MarvelHeroesTheme.colors.secondaryText
                    )
                }
            }
        }
    }
}
