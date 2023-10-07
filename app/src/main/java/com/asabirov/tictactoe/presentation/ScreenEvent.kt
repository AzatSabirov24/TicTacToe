package com.asabirov.tictactoe.presentation

sealed class ScreenEvent {

    object TapFirstPlayer: ScreenEvent()
    object TapSecondPlayer: ScreenEvent()
}
