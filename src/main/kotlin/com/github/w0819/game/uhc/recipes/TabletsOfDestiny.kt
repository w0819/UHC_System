package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta

object TabletsOfDestiny : ExtraUltimates(
    NamespacedKey.minecraft("tablets_of_destiny"),
    TabletsOfDestiny,
    250000,
    "Engineering","Enchanting"
) {
    init {
        shape(
            " 1 ",
            "234",
            "555"
        )
        setIngredient('1', Material.MAGMA_CREAM)
        setIngredient('2',Material.DIAMOND_SWORD)
        setIngredient('3',Material.WRITABLE_BOOK)
        setIngredient('4',Material.BOW)
        setIngredient('5',Material.EXPERIENCE_BOTTLE)
    }

    object TabletsOfDestiny : Item(
        ItemStack(Material.ENCHANTED_BOOK)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as EnchantmentStorageMeta).apply {
                    addStoredEnchant(Enchantment.DAMAGE_ALL, 3, true)
                    addStoredEnchant(Enchantment.FIRE_ASPECT, 1, true)
                    addStoredEnchant(Enchantment.ARROW_DAMAGE, 3, true)
                    addStoredEnchant(Enchantment.KNOCKBACK, 1, true)
                }
            }
        }
    }
}