package com.ebayula.marvelscomix.ui.common_components

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ebayula.marvelscomix.R
import com.ebayula.marvelscomix.ui.theme.MarvelHeroesTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = remember(decayAnimationSpec) {
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
    }

    SmallTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MarvelHeroesTheme.colors.primaryBackground
        ),
        title = {
            Text(
                text = stringResource(R.string.main_title),
                modifier = Modifier.fillMaxWidth(),
                style = MarvelHeroesTheme.typography.heading,
                color = MarvelHeroesTheme.colors.primaryText
            )
        },
        scrollBehavior = scrollBehavior
    )
}
