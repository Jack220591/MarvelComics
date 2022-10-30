package com.jack.marvelscomics.domain

import com.jack.marvelscomics.data.services.CharacterApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val characterApiService: CharacterApiService
) {
    fun getAllCharacters() = flow {
        emit(characterApiService.getAllCharacters())
    }.flowOn(Dispatchers.IO)

    fun getCharacterById(characterId: Int) = flow {
        emit(characterApiService.getCharacterById(characterId = characterId))
    }.flowOn(Dispatchers.IO)

    fun getCharacterComicsById(characterId: Int) = flow {
        emit(characterApiService.getCharacterComicsById(characterId))
    }.flowOn(Dispatchers.IO)
}