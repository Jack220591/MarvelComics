package com.ebayula.marvelscomix.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ebayula.marvelscomix.R

@Composable
fun MainTheme(
    style: MarvelHeroesStyle = MarvelHeroesStyle.Purple,
    textSize: MarvelHeroesSize = MarvelHeroesSize.Medium,
    paddingSize: MarvelHeroesSize = MarvelHeroesSize.Medium,
    corners: MarvelHeroesCorners = MarvelHeroesCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> {
            when (style) {
                MarvelHeroesStyle.Purple -> purpleDarkPalette
                MarvelHeroesStyle.Blue -> blueDarkPalette
                MarvelHeroesStyle.Orange -> orangeDarkPalette
                MarvelHeroesStyle.Red -> redDarkPalette
                MarvelHeroesStyle.Green -> greenDarkPalette
            }
        }
        false -> {
            when (style) {
                MarvelHeroesStyle.Purple -> purpleLightPalette
                MarvelHeroesStyle.Blue -> blueLightPalette
                MarvelHeroesStyle.Orange -> orangeLightPalette
                MarvelHeroesStyle.Red -> redLightPalette
                MarvelHeroesStyle.Green -> greenLightPalette
            }
        }
    }

    val typography = MarvelHeroesTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                MarvelHeroesSize.Small -> 24.sp
                MarvelHeroesSize.Medium -> 28.sp
                MarvelHeroesSize.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                MarvelHeroesSize.Small -> 14.sp
                MarvelHeroesSize.Medium -> 16.sp
                MarvelHeroesSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                MarvelHeroesSize.Small -> 14.sp
                MarvelHeroesSize.Medium -> 16.sp
                MarvelHeroesSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                MarvelHeroesSize.Small -> 10.sp
                MarvelHeroesSize.Medium -> 12.sp
                MarvelHeroesSize.Big -> 14.sp
            }
        )
    )

    val shapes = MarvelHeroesShape(
        padding = when (paddingSize) {
            MarvelHeroesSize.Small -> 12.dp
            MarvelHeroesSize.Medium -> 16.dp
            MarvelHeroesSize.Big -> 20.dp
        },
        cornersStyle = when (corners) {
            MarvelHeroesCorners.Flat -> RoundedCornerShape(0.dp)
            MarvelHeroesCorners.Rounded -> RoundedCornerShape(8.dp)
        }
    )

    val images = MarvelHeroesImage(
        mainIcon = if (darkTheme) androidx.core.R.drawable.notification_bg_low_pressed else coil.base.R.drawable.notification_action_background,
        mainIconDescription = if (darkTheme) "Good Mood" else "Bad Mood"
    )

    CompositionLocalProvider(
        LocalMarvelHeroesColors provides colors,
        LocalMarvelHeroesTypography provides typography,
        LocalMarvelHeroesShape provides shapes,
        LocalMarvelHeroesImage provides images,
        content = content
    )
}