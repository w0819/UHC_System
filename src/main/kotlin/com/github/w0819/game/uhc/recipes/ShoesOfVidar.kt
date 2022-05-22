package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object ShoesOfVidar: ExtraUltimates(
    NamespacedKey.minecraft("shoes_of_vidar"),
    ShoesOfVidar,
    150000,
    "Enchanting","Engineering","Survivalism"
) {
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.PUFFERFISH)
        setIngredient('2',Material.GLASS_BOTTLE)
        setIngredient('3',Material.DIAMOND_BOOTS)
        setIngredient('4',Material.FISHING_ROD)
    }

    object ShoesOfVidar : Item(
        ItemStack(Material.DIAMOND_BOOTS)
    ) {
        init {
            addEnchantment(Enchantment.DURABILITY,3)
            addEnchantment(Enchantment.PROTECTION_PROJECTILE,2)
            addEnchantment(Enchantment.THORNS,1)
        }
    }
}