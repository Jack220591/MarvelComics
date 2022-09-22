package com.ebayula.marvelscomix.presentation.screens.characters.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebayula.marvelscomix.R
import com.ebayula.marvelscomix.ui.theme.MainTheme
import com.ebayula.marvelscomix.ui.theme.MarvelHeroesTheme

@Composable
fun CharactersViewError(
    onReloadClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize().background(MarvelHeroesTheme.colors.primaryBackground),
    ) {
        Box(modifier = Modifier.fillMaxSize().background(MarvelHeroesTheme.colors.primaryBackground)) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(96.dp),
                    imageVector = Icons.Filled.Warning,
                    contentDescription = "Error loading items"
                )
                
                Text(
                    modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
                    text = stringResource(id = R.string.error_loading),
                    textAlign = TextAlign.Center
                )
                
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onReloadClick
                ) {
                    Text(
                        text = stringResource(id = R.string.action_refresh),
                        color = White
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun DailyViewError_Preview() {
    MainTheme(darkTheme = true) {
        CharactersViewError(onReloadClick = {})
    }
}