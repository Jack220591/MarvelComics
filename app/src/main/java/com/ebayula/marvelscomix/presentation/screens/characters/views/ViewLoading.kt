package com.ebayula.marvelscomix.presentation.screens.characters.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ebayula.marvelscomix.ui.theme.MainTheme
import com.ebayula.marvelscomix.ui.theme.MarvelHeroesTheme

@Composable
fun ViewLoading() {
    Box(modifier = Modifier.fillMaxSize().background(MarvelHeroesTheme.colors.primaryBackground)) {
        CircularProgressIndicator(
            modifier = Modifier.align(alignment = Alignment.Center),
            color = MarvelHeroesTheme.colors.tintColor
        )
    }
}

@Preview
@Composable
fun ViewLoading_Preview() {
    MainTheme(darkTheme = true) {
        ViewLoading()
    }
}