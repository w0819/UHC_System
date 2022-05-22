package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.WeaponSmithing
import net.kyori.adventure.text.Component.text
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta

object PowerIBook : WeaponSmithing(
    NamespacedKey.minecraft("power_i_book"),
    PowerIBook,
    3,
    true
) {
    init {
        shape(
            "1  ",
            " 22",
            " 23"
        )
        setIngredient('1',Material.FLINT)
        setIngredient('2',Material.PAPER)
        setIngredient('3',Material.BONE)
    }
    object PowerIBook : Item(
        ItemStack(Material.ENCHANTED_BOOK)
    ) {
        init {
            itemMeta = itemMeta.apply {
                displayName(text("Power I Book"))
                (this as EnchantmentStorageMeta).addStoredEnchant(Enchantment.ARROW_DAMAGE,1,true)
            }
        }
    }
}