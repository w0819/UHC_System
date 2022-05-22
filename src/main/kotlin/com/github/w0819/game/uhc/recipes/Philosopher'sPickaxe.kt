package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Engineering
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable

object `Philosopher'sPickaxe` : Engineering(
    NamespacedKey.minecraft("philosopher_pickaxe"),
    `Philosopher'sPickaxe`,
    1,
    true
) {
    init {
        shape(
            "121",
            "343",
            " 4 "
        )
        setIngredient('1', Material.IRON_ORE)
        setIngredient('2', Material.GOLD_ORE)
        setIngredient('3', Material.LAPIS_BLOCK)
        setIngredient('1',Material.DEEPSLATE_IRON_ORE)
        setIngredient('1',Material.DEEPSLATE_GOLD_ORE)
        setIngredient('4',Material.STICK)
    }
    object `Philosopher'sPickaxe` : Item(
        ItemStack(Material.DIAMOND_PICKAXE)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as Damageable).damage = 1559
            }
            addEnchantment(Enchantment.LOOT_BONUS_BLOCKS,2)
        }
    }
}