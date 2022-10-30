package com.jack.marvelscomics.presentation.navigation

sealed class Screen(val route: String) {
    object Characters: Screen("characters")
    object CharacterDetails: Screen("characterDetails/{characterId}") {
        fun passCharacterId(characterId: Int) = "characterDetails/$characterId"
    }

}

