package com.example.drinker.model

class CustomRepository(): BaseRepository {
    override fun giveHello(): String {
        return "Hello Koin"
    }

    override fun giveRepository(): String {
        return this.toString()
    }
}