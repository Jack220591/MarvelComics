package com.ebayula.marvelscomix.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class MarvelHeroesColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color,
    val indicatorsColor: Color,
    val navBarBackground: Color
)

data class MarvelHeroesTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle
)

data class MarvelHeroesShape(
    val padding: Dp,
    val cornersStyle: Shape
)

data class MarvelHeroesImage(
    val mainIcon: Int,
    val mainIconDescription: String
)

object MarvelHeroesTheme {
    val colors: MarvelHeroesColors
        @Composable
        get() = LocalMarvelHeroesColors.current

    val typography: MarvelHeroesTypography
        @Composable
        get() = LocalMarvelHeroesTypography.current

    val shapes: MarvelHeroesShape
        @Composable
        get() = LocalMarvelHeroesShape.current

    val images: MarvelHeroesImage
        @Composable
        get() = LocalMarvelHeroesImage.current
}

enum class MarvelHeroesStyle {
    Purple, Orange, Blue, Red, Green
}

enum class MarvelHeroesSize {
    Small, Medium, Big
}

enum class MarvelHeroesCorners {
    Flat, Rounded
}

val LocalMarvelHeroesColors = staticCompositionLocalOf<MarvelHeroesColors> {
    error("No colors provided")
}

val LocalMarvelHeroesTypography = staticCompositionLocalOf<MarvelHeroesTypography> {
    error("No font provided")
}

val LocalMarvelHeroesShape = staticCompositionLocalOf<MarvelHeroesShape> {
    error("No shapes provided")
}

val LocalMarvelHeroesImage = staticCompositionLocalOf<MarvelHeroesImage> {
    error("No images provided")
}