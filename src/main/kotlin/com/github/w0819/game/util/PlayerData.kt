package com.github.w0819.game.util

import com.github.w0819.game.util.uhc.UHC
import java.util.UUID

class PlayerData(private val player: UUID) {
    val uhcList = ArrayList<UHC>()
    var coins: Int = 0
}