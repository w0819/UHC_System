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
    fun giveKit(player: Player) {
        UHCPlugin.kitList.filter {
            it::class is ExtraUltimates
        }.random()[4].forEach {
            player.inventory.addItem(it)
        }
    }
}