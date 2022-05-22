package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ToolSmithing
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object QuickPick: ToolSmithing(
    NamespacedKey.minecraft("quick_pick"),
    QuickPick,
    3,
    true
) {
    init {
        shape(
            "111",
            "232",
            " 3 "
        )
        setIngredient('1', Material.IRON_ORE)
        setIngredient('2', Material.COAL)
        setIngredient('3', Material.STICK)
    }
    object QuickPick : Item(
        ItemStack(Material.IRON_PICKAXE)
    ) {
        init {
            addEnchantment(Enchantment.DIG_SPEED,1)
        }
    }
}