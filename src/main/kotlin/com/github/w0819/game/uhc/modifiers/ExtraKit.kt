package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.ExtraUltimates
import com.github.w0819.game.util.UHCModifier
import com.github.w0819.plugin.UHCPlugin
import org.bukkit.entity.Player

class ExtraKit : UHCModifier(
    "[⚒]",
    "[Extra Kit]",
    false

) {
     private tailrec fun giveKit(players: List<Player>) {
         if (players.isEmpty()) return
         val player = players[0]
        UHCPlugin.kitList.filter {
            it::class is ExtraUltimates
        }.random()[4].forEach {
            player.inventory.addItem(it)
        }
         giveKit(players - player)
    }

    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        giveKit(players)
    }
}