package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object `Artemis'sBow` : ExtraUltimates(
    NamespacedKey.minecraft("artemis_bow"),
    `Artmeis'sBow`,
    100000,
    "Alchemy","BloodCraft"
) {
    init {
        shape(
            "121",
            "131",
            "141"
        )
        setIngredient('1', Material.FEATHER)
        setIngredient('2',Material.DIAMOND)
        setIngredient('3',Material.BOW)
        setIngredient('4',Material.ENDER_EYE)
    }
    object `Artmeis'sBow` : Item(
        ItemStack(Material.BOW)
    ) {
        init {
            addEnchantment(Enchantment.ARROW_DAMAGE,3)
        }
    }
}