package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.WeaponSmithing
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object VorpalSword : WeaponSmithing(
    NamespacedKey.minecraft("vorpal_sword"),
    VorpalSword,
    3,
    true
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.BONE)
        setIngredient('2',Material.IRON_SWORD)
        setIngredient('3',Material.ROTTEN_FLESH)
    }
    object VorpalSword : Item(
        ItemStack(Material.IRON_SWORD)
    ) {
        init {
            addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 2)
            addEnchantment(Enchantment.DAMAGE_UNDEAD, 2)
            addEnchantment(Enchantment.LOOT_BONUS_MOBS, 2)
        }
    }
}