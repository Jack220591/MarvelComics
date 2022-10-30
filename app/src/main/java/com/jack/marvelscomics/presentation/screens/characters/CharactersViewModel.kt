package com.jack.marvelscomics.presentation.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jack.marvelscomics.domain.CharactersRepository
import com.jack.marvelscomics.presentation.screens.characters.models.CharactersViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
): ViewModel() {
    
    private val _charactersCharactersViewState: MutableStateFlow<CharactersViewState> = MutableStateFlow(CharactersViewState.Loading)
    val charactersCharactersViewState: StateFlow<CharactersViewState>
        get() = _charactersCharactersViewState

    fun fetchCharacters() {
        viewModelScope.launch {
            charactersRepository.getAllCharacters()
                .onStart { _charactersCharactersViewState.value = CharactersViewState.Loading }
                .catch { _charactersCharactersViewState.value = CharactersViewState.Error }
                .collectLatest { result ->
                    result.data?.results?.let {
                        if (it.isEmpty()) {
                            _charactersCharactersViewState.value = CharactersViewState.NoneData
                        } else {
                            _charactersCharactersViewState.value = CharactersViewState.Success(it)
                        }
                    } ?: kotlin.run { _charactersCharactersViewState.value = CharactersViewState.NoneData }

                }
        }
    }

}