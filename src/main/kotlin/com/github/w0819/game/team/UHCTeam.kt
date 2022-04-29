package com.github.w0819.game.team

import com.github.w0819.game.util.uhc.UHC
import com.github.w0819.game.util.Util
import org.bukkit.entity.Player

data class UHCTeam(val players: List<Player>) : UHC {
    companion object {
        @JvmStatic
        fun divide(players: List<Player>, playerPerTeam: Int): List<UHCTeam> {
            return Util.divide(players, playerPerTeam).map { UHCTeam(it) }
        }
    }
    override fun toString(): String {
        return "$players"
    }
}