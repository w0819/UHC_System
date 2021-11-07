package com.github.w0819.game.util

import com.github.w0819.game.team.UHCTeam
import org.bukkit.World
import java.util.*

class GameUtils {
    companion object {
        @JvmStatic
        fun spreadTeams(teams: List<UHCTeam>, world: World? = null) {
            val xBounds = 3001
            val yBounds = 3001
            val random = Random()

            for (team in teams) {
                val x = random.nextInt(xBounds) - 1500
                val z = random.nextInt(yBounds) - 1500

                team.players.forEach {
                    it.teleport((world ?: it.world).getHighestBlockAt(x, z).location)
                }
            }
        }
    }
}