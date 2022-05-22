package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Enchanting
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object LightEnchantingTable : Enchanting(
    NamespacedKey.minecraft("light_enchanting_table"),
    LightEnchantingTable,
    3,
    true
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
    object LightEnchantingTable : Item(
        ItemStack(Material.ENCHANTING_TABLE)
    )
}