package com.ebayula.marvelscomix.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ComicsDataContainer(
    val offset: Int? = null,
    val limit: Int? = null,
    val total: Int? = null,
    val count: Int? = null,
    val results: List<Comic>
)
