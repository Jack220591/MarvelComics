package com.ebayula.marvelscomix.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class StoryList(
    val available: Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items: List<StorySummary>?
)
@Serializable
data class StorySummary(
    val resourceURI: String?,
    val name: String?,
    val type: String?
)
