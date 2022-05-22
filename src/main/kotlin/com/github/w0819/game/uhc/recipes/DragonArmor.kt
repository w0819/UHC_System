package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ArmorSmithing
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object DragonArmor : ArmorSmithing(
    NamespacedKey.minecraft("dragon_armor"),
    DragonArmor,
    1,
    true
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            "343"
        )
        setIngredient('1', Material.MAGMA_CREAM)
        setIngredient('2', Material.DIAMOND_CHESTPLATE)
        setIngredient('3', Material.OBSIDIAN)
        setIngredient('4', Material.ANVIL)
    }
    object DragonArmor : Item(
        ItemStack(Material.DIAMOND_CHESTPLATE)
    ) {
        init {
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4)
        }
    }
}