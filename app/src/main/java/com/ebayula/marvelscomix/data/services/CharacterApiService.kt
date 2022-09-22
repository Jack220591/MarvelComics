package com.ebayula.marvelscomix.data.services

import com.ebayula.marvelscomix.Constans
import com.ebayula.marvelscomix.Constans.PUBLIC_API_KEY
import com.ebayula.marvelscomix.domain.models.CharactersDataContainer
import com.ebayula.marvelscomix.domain.models.ComicsDataContainer
import com.ebayula.marvelscomix.domain.models.DataWrapper
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query("apikey") apikey: String = PUBLIC_API_KEY,
        @Query("ts") ts: String = Constans.timestamp,
        @Query("hash") hash: String = Constans.hash(),
        @Query("orderBy") orderBy: String = "modified",
        @Query("limit") limit: String = "99"
    ): DataWrapper<CharactersDataContainer>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: Int,
        @Query("apikey") apikey: String = PUBLIC_API_KEY,
        @Query("ts") ts: String = Constans.timestamp,
        @Query("hash") hash: String = Constans.hash()
    ): DataWrapper<CharactersDataContainer>


    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getCharacterComicsById(
        @Path("characterId") characterId: Int,
        @Query("apikey") apikey: String = PUBLIC_API_KEY,
        @Query("ts") ts: String = Constans.timestamp,
        @Query("hash") hash: String = Constans.hash()
    ): DataWrapper<ComicsDataContainer>
}