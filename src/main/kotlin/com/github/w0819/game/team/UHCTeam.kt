package com.github.w0819.game.team

import com.github.w0819.util.ListUtils
import org.bukkit.entity.Player

data class UHCTeam(val players: List<Player>) {
    companion object {
        @JvmStatic
        fun divide(players: List<Player>, playerPerTeam: Int): List<UHCTeam> {
            return ListUtils.divide(players, playerPerTeam).map { UHCTeam(it) }
        }
    }
}