package com.github.w0819.recipes

import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class LightEnchantingTable : UHCRecipe(
    NamespacedKey.minecraft("light_enchanting_table"),
    ItemStack(Material.ENCHANTING_TABLE)
){
    init {
        shape(
            " 1 ",
            "232",
            "242"
        )
        setIngredient('1',Material.BOOKSHELF)
        setIngredient('2',Material.OBSIDIAN)
        setIngredient('3',Material.DIAMOND)
        setIngredient('4',Material.EXPERIENCE_BOTTLE)
    }
}