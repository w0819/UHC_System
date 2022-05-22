package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Survivalism
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object SpikedArmor : Survivalism(
    NamespacedKey.minecraft("spiked_armor"),
    SpikedArmor,
    3,
    true
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1',Material.LILY_PAD)
        setIngredient('2',Material.CACTUS)
        setIngredient('3',Material.LEATHER_CHESTPLATE)
    }
    object SpikedArmor : Item(
        ItemStack(Material.LEATHER_CHESTPLATE)
    ) {
        init {
            addEnchantment(Enchantment.THORNS,1)
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,4)
        }
    }
}