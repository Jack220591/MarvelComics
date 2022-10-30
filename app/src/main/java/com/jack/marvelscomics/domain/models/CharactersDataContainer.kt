package com.jack.marvelscomics.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class CharactersDataContainer(
    val offset: Int? = null,
    val limit: Int? = null,
    val total: Int? = null,
    val count: Int? = null,
    val results: List<MarvelCharacter>? = null
)
