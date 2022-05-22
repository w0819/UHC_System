package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.uhc.UHCModifier
import org.bukkit.entity.Player

class TimeNight : UHCModifier(
    "[\uD83C\uDF19]",
    "[Time Night]",
    false
) {
    companion object {
        @JvmStatic
        tailrec fun playerNight(players: List<Player>) {
            if (players.isEmpty()) return
            val player = players[0]
            player.setPlayerTime(15600L,true)
            playerNight(players - player)
        }
    }
    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        playerNight(players)
    }
}