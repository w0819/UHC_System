package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.ExtraUltimates
import com.github.w0819.game.util.UHCModifier
import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.game.util.Ultimates
import com.github.w0819.plugin.UHCPlugin
import com.github.w0819.plugin.UHCPlugin.Companion.game
import org.bukkit.entity.Player

class StartingUltimate : UHCModifier(
    "[\uD83D\uDDE1]",
    "[Starting Ultimate]",
    false
) {
    private tailrec fun startingUltimate(players: List<Player>, teamGame: Boolean) {
        tailrec fun startingUltimate(gives: Set<UHCRecipe>,maxSize: Int): Set<UHCRecipe> = if (gives.size == maxSize) gives else if (gives.size > maxSize) {
            startingUltimate(gives.drop(1).toSet(),maxSize)
        } else {
            val ultimates = UHCPlugin.recipeList.filterIsInstance<Ultimates>().filterIsInstance<UHCRecipe>()
            val extraUltimates = UHCPlugin.recipeList.filterIsInstance<ExtraUltimates>().filterIsInstance<UHCRecipe>()
            startingUltimate((gives + ultimates.random()) + extraUltimates.random(), maxSize)
        }
        if (players.isEmpty()) return
        val player = players[0]
        if (teamGame) {
            val playersTeam = game?.teams?.find { it.players.contains(player) }
            playersTeam?.players?.forEach { teamPlayer ->
                teamPlayer.inventory.addItem(*startingUltimate(setOf(),2).map { it.result }.toTypedArray())
            }
        } else
            player.inventory.addItem(*startingUltimate(setOf(),2).map { it.result }.toTypedArray())
        startingUltimate(players - player,teamGame)
    }
    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        startingUltimate(players,(game?: return).teamGame)
    }
}