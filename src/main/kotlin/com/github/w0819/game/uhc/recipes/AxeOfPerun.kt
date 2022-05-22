package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object AxeOfPerun : ExtraUltimates(
    NamespacedKey.minecraft("axe_of_perun"),
    AxeOfPerun,
    150000,
    "Enchanting","WeaponWmithing"
) {
    init {
        shape(
            "123",
            "14 ",
            " 4 "
        )
        setIngredient('1', Material.DIAMOND)
        setIngredient('2',Material.TNT)
        setIngredient('3',Material.FIRE_CHARGE)
        setIngredient('4',Material.STICK)
    }
    object AxeOfPerun : Item(
        ItemStack(Material.DIAMOND_AXE)
    ) {
        init {
            addEnchantment(Enchantment.DURABILITY,1)
        }
    }
}