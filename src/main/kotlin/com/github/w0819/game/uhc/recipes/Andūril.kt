package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object Andūril : ExtraUltimates(
    NamespacedKey.minecraft("anduril"),
    Andūril,
    150000,
    "Engineering","WeaponSmithing"
) {
    init {
        shape(
            "121",
            "121",
            "131"
        )
        setIngredient('1', Material.FEATHER)
        setIngredient('2',Material.IRON_BLOCK)
        setIngredient('3',Material.BLAZE_ROD)
    }
    object Andūril : Item(
        ItemStack(Material.IRON_SWORD),
        lore = mutableListOf(
            Component.text("Gives Speed 1 and Resistance 1 to the user while holding"),
        )
    ) {
        init {
            addEnchantment(Enchantment.DAMAGE_ALL,3)
        }
    }
}