package com.github.w0819.recipes

import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta

class BookOfPower : UHCRecipe(
    NamespacedKey.minecraft("book_of_power"),
    ItemStack(Material.ENCHANTED_BOOK).apply {
        itemMeta = itemMeta.apply {
            (this as EnchantmentStorageMeta).addStoredEnchant(Enchantment.ARROW_DAMAGE, 1, true)
        }
    }
) {
    init {
        shape(
            "1  ",
            " 22",
            " 23"
        )
        setIngredient('1', Material.FLINT)
        setIngredient('2', Material.PAPER)
        setIngredient('3', Material.BONE)
    }
}