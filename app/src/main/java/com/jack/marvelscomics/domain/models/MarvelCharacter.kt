package com.jack.marvelscomics.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class MarvelCharacter(
    val id: Int?,
    val name: String?,
    val description: String?,
    val modified: String?,
    val resourceURI: String?,
    val urls: List<Url>?,
    val thumbnail: Image?,
    val comics: ComicList?,
    val stories: StoryList?,
    val events: EventList?,
    val series: SeriesList?
)

@Serializable
data class Url(
    val type: String?,
    val url: String?
)
@Serializable
data class Image(
    val path: String?,
    val extension: String?
)

