package com.jack.marvelscomics.presentation.screens.characters.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jack.marvelscomics.ui.theme.MainTheme

@Composable
fun ViewLoading() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.align(alignment = Alignment.Center),
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