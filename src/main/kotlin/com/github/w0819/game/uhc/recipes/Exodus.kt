package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object Exodus :  ExtraUltimates(
    NamespacedKey.minecraft("exodus"),
    Exodus,
    350000,
    "Engineering","BloodCraft","Cooking","ArmorSmithing"
) {
    init {
        shape(
            "111",
            "121",
            "343"
        )
        setIngredient('1', Material.DIAMOND)
        setIngredient('2',Material.PLAYER_HEAD)
        setIngredient('3',Material.EMERALD)
        setIngredient('4',Material.GOLDEN_CARROT)
    }
    object Exodus : Item(
        ItemStack(Material.DIAMOND_HELMET)
    ) {
        init {
            addEnchantment(Enchantment.DURABILITY,3)
        }
    }
}