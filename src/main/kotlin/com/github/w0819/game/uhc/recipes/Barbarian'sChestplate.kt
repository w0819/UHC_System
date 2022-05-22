package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object `Barbarian'sChestplate` : ExtraUltimates(
    NamespacedKey.minecraft("barbarian_chestplate"),
    `Barbarian'sChestplate`,
    250000,
    "BloodCraft","Hunter"
){
    init {
        shape(
            "121",
            "343",
            "   "
        )
        setIngredient('1', Material.BLAZE_ROD)
        setIngredient('2',Material.DIAMOND_CHESTPLATE)
        setIngredient('3',Material.IRON_BLOCK)
        setIngredient('4',Material.POTION)
    }
    object `Barbarian'sChestplate` : Item(
        ItemStack(Material.DIAMOND_CHESTPLATE)
    ) {
        init {
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1)
        }
    }
}