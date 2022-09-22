package com.ebayula.marvelscomix.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class EventList(
    val available: Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items: List<EventSummary>?
)

@Serializable
data class EventSummary(
    val resourceURI: String?,
    val name: String?
)
