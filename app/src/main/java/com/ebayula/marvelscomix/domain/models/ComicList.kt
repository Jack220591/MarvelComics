package com.ebayula.marvelscomix.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ComicList(
    val available: Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items: List<ComicSummary>?
)
@Serializable
data class ComicSummary(
    val resourceURI: String?,
    val name: String?
)
