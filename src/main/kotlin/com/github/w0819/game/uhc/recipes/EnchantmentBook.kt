package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ToolSmithing
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object EnchantmentBook : ToolSmithing(
    NamespacedKey.minecraft("enchantment_book"),
    EnchantmentBook,
    1,
    true
){
    init {
        shape(
            "111",
            "232",
            "444"
        )
        setIngredient('1',Material.EXPERIENCE_BOTTLE)
        setIngredient('2',Material.IRON_AXE)
        setIngredient('3',Material.ENCHANTING_TABLE)
        setIngredient('4',Material.BOOKSHELF)
    }
    object EnchantmentBook : Item(
        ItemStack(Material.ENCHANTING_TABLE)
    )
}