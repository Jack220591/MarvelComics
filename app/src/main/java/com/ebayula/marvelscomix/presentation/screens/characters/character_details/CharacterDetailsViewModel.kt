package com.ebayula.marvelscomix.presentation.screens.characters.character_details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebayula.marvelscomix.domain.CharactersRepository
import com.ebayula.marvelscomix.presentation.screens.characters.models.CharactersViewState
import com.ebayula.marvelscomix.presentation.screens.characters.models.ComicsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
): ViewModel() {

    private val _charactersViewState: MutableStateFlow<CharactersViewState> = MutableStateFlow(
        CharactersViewState.Loading)
    val charactersViewState: StateFlow<CharactersViewState>
        get() = _charactersViewState

    private val _comicsViewState: MutableStateFlow<ComicsViewState> = MutableStateFlow(
        ComicsViewState.Loading)
    val comicsViewState: StateFlow<ComicsViewState>
        get() = _comicsViewState


    fun fetchCharactersById(characterId: Int) {
        viewModelScope.launch {
            charactersRepository.getCharacterById(characterId)
                .onStart { _charactersViewState.value = CharactersViewState.Loading }
                .catch { _charactersViewState.value = CharactersViewState.Error }
                .collectLatest { result ->
                    result.data?.results?.let {
                        if (it.isEmpty()) {
                            _charactersViewState.value = CharactersViewState.NoneData
                        } else {
                            _charactersViewState.value = CharactersViewState.Success(it)
                        }
                    } ?: kotlin.run { _charactersViewState.value = CharactersViewState.NoneData }

                }
        }
    }

    fun fetchComics(characterId: Int) {
        viewModelScope.launch {
            charactersRepository.getCharacterComicsById(characterId = characterId)
                .onStart { _comicsViewState.value = ComicsViewState.Loading }
                .catch {
                    Log.d("fetchComics", "${it.localizedMessage}")
                    _comicsViewState.value = ComicsViewState.Error }
                .collectLatest { result ->

                    result.data?.results?.let {
                        if (it.isEmpty()) {
                            _comicsViewState.value = ComicsViewState.NoneData
                        } else {
                            _comicsViewState.value = ComicsViewState.Success(it)
                        }
                    } ?: kotlin.run { _comicsViewState.value = ComicsViewState.NoneData }
                }
        }
    }
}