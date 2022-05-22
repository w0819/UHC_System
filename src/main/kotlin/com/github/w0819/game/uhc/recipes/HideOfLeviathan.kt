package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object HideOfLeviathan : ExtraUltimates(
    NamespacedKey.minecraft("hide_of_leviathan"),
    HideOfLeviathan,
    150000,
    "ArmorSmithing","Survivalism"
) {
    init {
        shape(
            "121",
            "343",
            "5 5"
        )
        setIngredient('1', Material.LAPIS_BLOCK)
        setIngredient('2',Material.WATER_BUCKET)
        setIngredient('3',Material.DIAMOND)
        setIngredient('4',Material.DIAMOND_LEGGINGS)
        setIngredient('5',Material.LILY_PAD)
    }
    object HideOfLeviathan : Item(
        ItemStack(Material.DIAMOND_LEGGINGS)
    ) {
        init {
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4)
        }
    }

}