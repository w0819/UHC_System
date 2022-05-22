package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object Bloodlust : ExtraUltimates(
    NamespacedKey.minecraft("bloodlust"),
    Bloodlust,
    100000,
    "BloodCraft","Invention"
) {
    init {
        shape(
            "121",
            "131",
            "141"
        )
        setIngredient('1', Material.REDSTONE_BLOCK)
        setIngredient('2',Material.DIAMOND)
        setIngredient('3',Material.DIAMOND_SWORD)
        setIngredient('4',Material.EXPERIENCE_BOTTLE)
    }

    object Bloodlust : Item(
        ItemStack(Material.DIAMOND_SWORD)
    )
}