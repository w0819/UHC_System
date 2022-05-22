package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object EssenceOfYggdrasil : ExtraUltimates(
    NamespacedKey.minecraft("essence_of_yggdrasil"),
    EssenceOfYggdrasil,
    75000,
    "Enchanting","Alchemy"
) {
    init {
        shape(
            "121",
            "343",
            "151"
        )
        setIngredient('1',Material.OAK_LEAVES)
        setIngredient('2',Material.ENCHANTING_TABLE)
        setIngredient('3',Material.GLOWSTONE)
        setIngredient('4',Material.GLASS_BOTTLE)
        setIngredient('5',Material.REDSTONE)
    }

    object EssenceOfYggdrasil : Item(
        ItemStack(Material.ENCHANTING_TABLE)
    )
}