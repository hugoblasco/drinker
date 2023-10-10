package com.example.drinker.model

data class GameDomainModel(
    val id: Int,
    val name: String,
    val dicesRequired: Boolean,
    val cardsRequired: Boolean,
    val time: Int,
    val upVotes: Int,
    val downVotes: Int,
    val isFavorite: Boolean,
)