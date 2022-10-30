package com.jack.marvelscomics.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class DataWrapper<T>(
    val code: Int? = null,
    val status: String? = null,
    val copyright: String? = null,
    val attributionText: String? = null,
    val attributionHTML: String? = null,
    val data: T? = null,
    val etag: String? = null
)
