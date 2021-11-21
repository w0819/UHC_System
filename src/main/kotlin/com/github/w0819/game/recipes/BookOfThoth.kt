package com.github.w0819.game.recipes

import com.github.w0819.game.util.UHCRecipe
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta

class BookOfThoth : UHCRecipe(
    NamespacedKey.minecraft("book_of_thoth"),
        ItemStack(Material.ENCHANTED_BOOK).apply {
        itemMeta = itemMeta.apply {
            displayName(Component.text("Book of Sharpening"))
            (this as EnchantmentStorageMeta).addStoredEnchant(Enchantment.DAMAGE_ALL, 2, true)
        }
            ItemStack(Material.ENCHANTED_BOOK).apply {
                itemMeta = itemMeta.apply {
                    displayName(Component.text("Book of Protection "))
                    (this as EnchantmentStorageMeta).addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3,true)
                }
            }
            ItemStack(Material.ENCHANTED_BOOK).apply {
                itemMeta = itemMeta.apply {
                    displayName(Component.text("Fire Aspect"))
                    (this as EnchantmentStorageMeta).addStoredEnchant(Enchantment.FIRE_ASPECT,1,true)
                }
            }
            ItemStack(Material.ENCHANTED_BOOK).apply {
                itemMeta = itemMeta.apply {
                    displayName(Component.text("Power"))
                    (this as EnchantmentStorageMeta).addStoredEnchant(Enchantment.ARROW_DAMAGE,3,true)
                }
            }
    }
){
    init {
        shape(
            "1  ",
            " 22",
            " 23"
        )
        setIngredient('1',Material.ENDER_EYE)
        setIngredient('2',Material.PAPER)
        setIngredient('3',Material.FIRE_CHARGE)
    }
}