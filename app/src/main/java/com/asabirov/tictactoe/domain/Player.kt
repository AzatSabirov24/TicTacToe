package com.asabirov.tictactoe.domain

sealed class Player(val name: String) {

    object FirstPlayer : Player(FIRST_PLAYER)
    object SecondPlayer : Player(SECOND_PLAYER)

    fun fromString(name: String): Player {
        return when (name) {
            "firstPlayer" -> FirstPlayer
            "secondPlayer" -> SecondPlayer
            else -> FirstPlayer
        }
    }

    companion object {

        const val FIRST_PLAYER = "firstPlayer"
        const val SECOND_PLAYER = "secondPlayer"
    }
}
