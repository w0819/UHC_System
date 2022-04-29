package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.uhc.UHCModifier
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class BrewMaster : UHCModifier(
    "[\uD83C\uDF7A]",
    "[Brew Master]",
    false
) {
    private fun giveBrewIngredient(players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        player.inventory.addItem(ItemStack(Material.BREWING_STAND,3),ItemStack(Material.NETHER_WART,3),
            ItemStack(Material.GLASS_BOTTLE,9)
        )
    }

    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        giveBrewIngredient(players)
    }
}