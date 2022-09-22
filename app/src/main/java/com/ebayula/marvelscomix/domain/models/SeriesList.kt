package com.ebayula.marvelscomix.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class SeriesList(
    val available: Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items: List<SeriesSummary>?
)

@Serializable
data class SeriesSummary(
    val resourceURI: String?,
    val name: String?
)
