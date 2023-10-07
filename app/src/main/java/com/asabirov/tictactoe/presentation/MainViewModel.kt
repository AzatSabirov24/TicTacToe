package com.asabirov.tictactoe.presentation

import androidx.lifecycle.ViewModel
import com.asabirov.tictactoe.domain.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _player = MutableStateFlow(Player.FirstPlayer)
    val player = _player.asStateFlow()

//    fun onEvent(event: ScreenEvent) {
//        when(event) {
//            is ScreenEvent.TapFirstPlayer -> _player.update {
//                it =
//            }
//            is ScreenEvent.TapSecondPlayer -> _player.emit(Player.SecondPlayer)
//        }
//    }
}