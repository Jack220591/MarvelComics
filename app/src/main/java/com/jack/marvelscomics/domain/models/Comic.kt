package com.jack.marvelscomics.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Comic(
    val id: Int?,
    val digitalId: Int?,
    val title: String?,
    val issueNumber: Double?,
    val variantDescription: String?,
    val description: String?,
    /*@Serializable(DateSerializer::class) val modified: Date?,*/
    val isbn: String?,
    val upc: String?,
    val diamondCode: String?,
    val ean: String?,
    val issn: String?,
    val format: String?,
    val pageCount: Int?,
    val textObjects: List<TextObject>?,
    val resourceUri: String? = null,
    val urls: List<Url>?,
    val series: SeriesSummary?,
    val variants: List<ComicSummary>?,
    val collections: List<ComicSummary>?,
    val collectedIssues: List<ComicSummary>?,
    val dates: List<ComicDate>?,
    val prices: List<ComicPrice>?,
    val thumbnail: Image?,
    val images: List<Image>?,
    val creators: CreatorList?,
    val characters: CharacterList?,
    val stories: StoryList?,
    val events: EventList?
)

@Serializable
data class TextObject(
    val type: String?,
    val language: String?,
    val text: String?
)

@Serializable
data class ComicDate(
    val type: String?,
    /*@Serializable(DateSerializer::class)  val date: Date?*/
)

@Serializable
data class ComicPrice(
    val type: String?,
    val price: Float?
)

@Serializable
data class CreatorList(
    val available: Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items: List<CreatorSummary>?
)

@Serializable
data class CreatorSummary(
    val resourceURI: String?,
    val name: String?,
    val role: String?
)

@Serializable
data class CharacterList(
    val available: Int?,
    val returned: Int?,
    val collectionURI: String?,
    val items: List<CharacterSummary>?
)

@Serializable
data class CharacterSummary(
    val resourceURI: String?,
    val name: String?,
    val role: String? = null
)
