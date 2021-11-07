package com.github.w0819.util

import com.github.w0819.team.UHCTeam
import java.util.*

class GameUtils {
    companion object {
        @JvmStatic
        fun spreadTeams(teams: List<UHCTeam>) {
            val xBounds = 3001
            val yBounds = 3001
            val random = Random()

            for (team in teams) {
                val x = random.nextInt(xBounds) - 1500
                val z = random.nextInt(yBounds) - 1500

                team.players.forEach {
                    it.teleport(it.world.getHighestBlockAt(x, z).location)
                }
            }
        }
    }
}