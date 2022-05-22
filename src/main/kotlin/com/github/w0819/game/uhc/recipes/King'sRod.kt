package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object `King'sRod` : ExtraUltimates(
    NamespacedKey.minecraft("king_s_rod"),
    `King'sRod`,
    50000,
    "Survivalism","Enchanting"
) {
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.FISHING_ROD)
        setIngredient('2',Material.LILY_PAD)
        setIngredient('3',Material.COMPASS)
        setIngredient('4',Material.WATER_BUCKET)
    }
    object `King'sRod` : Item(
        ItemStack(Material.FISHING_ROD)
    ) {
        init {
            addEnchantment(Enchantment.LURE,3)
            addEnchantment(Enchantment.DURABILITY,3)
        }
    }
}