package com.ebayula.marvelscomix.presentation.screens.characters.models

import com.ebayula.marvelscomix.domain.models.MarvelCharacter

sealed class CharactersViewState {
    object Loading: CharactersViewState()
    data class Success(val data: List<MarvelCharacter>): CharactersViewState()
    object NoneData: CharactersViewState()
    object Error: CharactersViewState()
}
