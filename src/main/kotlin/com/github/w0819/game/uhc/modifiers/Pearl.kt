package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.uhc.UHCModifier
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Pearl : UHCModifier(
    "[\uD83C\uDF00]",
    "[Pearl]",
false
) {
    private tailrec fun giveEnderPearl(players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        player.inventory.addItem(ItemStack(Material.ENDER_PEARL,3))
        giveEnderPearl(players - player)
    }

    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        giveEnderPearl(players)
    }
}