package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object ModularBow : ExtraUltimates(
    NamespacedKey.minecraft("modular_bow"),
    ModularBow,
    150000,
    "Invention","WephonSmithing"
) {
    init {
        shape(
            " 1 ",
            "232",
            "454"
        )
        setIngredient('1', Material.CLOCK)
        setIngredient('2',Material.BLAZE_POWDER)
        setIngredient('3',Material.BOW)
        setIngredient('4',Material.SPIDER_EYE)
        setIngredient('5',Material.SLIME_BALL)
    }
    object ModularBow : Item(
        ItemStack(Material.BOW)
    ) {
        init {
            addEnchantment(Enchantment.ARROW_KNOCKBACK,1)
        }
    }
}