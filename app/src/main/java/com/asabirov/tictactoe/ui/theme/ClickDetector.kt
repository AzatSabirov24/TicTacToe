package com.asabirov.tictactoe.ui.theme

import com.asabirov.tictactoe.ui.CellType

class ClickDetector {

    operator fun invoke(x: Float, y: Float): CellType {
        return when {
            x in 102f..300f && y in 102f..300f -> CellType.FirstCellType
            x in -98f..98f && y in 102f..300f -> CellType.SecondCellType
            x in -300f..-102f && y in 102f..300f -> CellType.ThirdCellType
            x in 102f..300f && y in -98f..98f -> CellType.ForthCellType
            x in -98f..98f && y in -98f..98f -> CellType.FifthCellType
            x in -300f..-102f && y in -98f..98f -> CellType.SixthCellType
            x in 102f..300f && y in -300f..-102f -> CellType.SeventhCellType
            x in -98f..98f && y in -300f..-102f -> CellType.EighthCellType
            x in -300f..-102f && y in -300f..-102f -> CellType.NinthCellType
            else -> CellType.OutOfCellType
        }
    }
}