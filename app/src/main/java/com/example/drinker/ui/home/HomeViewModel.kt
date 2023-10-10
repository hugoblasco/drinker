package com.example.drinker.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinker.model.GameDomainModel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class HomeViewModel : ViewModel(), KoinComponent {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _gameList = MutableLiveData<List<GameDomainModel>>()
    val gameList: LiveData<List<GameDomainModel>>
        get() = _gameList

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch {

            val games = listOf(
                GameDomainModel(
                    id = 1,
                    name = "Petit Jésus",
                    dicesRequired = false,
                    cardsRequired = true,
                    time = 3,
                    upVotes = 0,
                    downVotes = 0,
                    isFavorite = false,
                ),
                GameDomainModel(
                    id = 2,
                    name = "Biskit",
                    dicesRequired = true,
                    cardsRequired = false,
                    time = 3,
                    upVotes = 0,
                    downVotes = 0,
                    isFavorite = false,
                ),
                GameDomainModel(
                    id = 3,
                    name = "PMU",
                    dicesRequired = false,
                    cardsRequired = true,
                    time = 1,
                    upVotes = 0,
                    downVotes = 0,
                    isFavorite = false,
                ),
                GameDomainModel(
                    id = 4,
                    name = "VROUM",
                    dicesRequired = false,
                    cardsRequired = false,
                    time = 1,
                    upVotes = 0,
                    downVotes = 0,
                    isFavorite = false,
                ),
                GameDomainModel(
                    id = 5,
                    name = "Parcours",
                    dicesRequired = true,
                    cardsRequired = true,
                    time = 2,
                    upVotes = 0,
                    downVotes = 0,
                    isFavorite = false,
                ),
            )

            _gameList.postValue(games)
        }
    }
}