package com.github.w0819.game.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta

class BookOfProtection : UHCRecipe(
    NamespacedKey.minecraft("book_of_protection"),
    ItemStack(Material.ENCHANTED_BOOK).apply {
        itemMeta = itemMeta.apply {
            (this as EnchantmentStorageMeta).addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true)
        }
    }
) {
    init {
        shape(
            "   ",
            " 11",
            " 12"
        )
        setIngredient('1', Material.PAPER)
        setIngredient('2', Material.IRON_INGOT)
    }
}