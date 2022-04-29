package com.github.w0819.game.uhc.modifiers

import com.github.w0819.game.util.uhc.UHCModifier
import com.github.w0819.plugin.UHCPlugin
import com.github.w0819.plugin.UHCPlugin.Companion.game
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ShortGrace : UHCModifier(
    "[☮]",
    "[short Grace]",
    false
)  {
    private tailrec fun shortGrace(players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        player.inventory.apply {
            helmet = ItemStack(Material.IRON_HELMET)
            chestplate = ItemStack(Material.IRON_CHESTPLATE)
            leggings = ItemStack(Material.IRON_LEGGINGS)
            boots = ItemStack(Material.IRON_BOOTS)
        }
        player.inventory.addItem(
            ItemStack(Material.IRON_HOE),
            ItemStack(Material.IRON_AXE),
            ItemStack(Material.IRON_PICKAXE),
            ItemStack(Material.IRON_SHOVEL)
        )
        player.inventory.addItem(*UHCPlugin.kitList().random()[4].toTypedArray())
        shortGrace(players - player)
    }
    override fun specialSkill(players: List<Player>) {
        super.specialSkill(players)
        shortGrace(players)
        game.timer.setGraceTime(3)
    }
}