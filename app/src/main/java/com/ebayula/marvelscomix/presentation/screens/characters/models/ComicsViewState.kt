package com.ebayula.marvelscomix.presentation.screens.characters.models

import com.ebayula.marvelscomix.domain.models.Comic

sealed class ComicsViewState {
    object Loading: ComicsViewState()
    data class Success(val data: List<Comic>): ComicsViewState()
    object NoneData: ComicsViewState()
    object Error: ComicsViewState()
}
