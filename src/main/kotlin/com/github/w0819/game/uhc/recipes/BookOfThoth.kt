package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Enchanting
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta

object BookOfThoth : Enchanting(
    NamespacedKey.minecraft("book_of_thoth"),
    BookOfThoth,
    1,
    true
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
    object BookOfThoth : Item(
        ItemStack(Material.ENCHANTED_BOOK).apply {
            itemMeta = itemMeta.apply {
                displayName(Component.text("Book of Thoth"))
                (this as EnchantmentStorageMeta).apply {
                    addStoredEnchant(Enchantment.DAMAGE_ALL, 2, true)
                    addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3,true)
                    addStoredEnchant(Enchantment.FIRE_ASPECT,1,true)
                    addStoredEnchant(Enchantment.ARROW_DAMAGE,3,true)
                }
            }
        }
    )
}