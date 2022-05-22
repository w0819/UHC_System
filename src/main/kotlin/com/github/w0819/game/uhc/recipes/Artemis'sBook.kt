package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ArmorSmithing
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta

object `Artemis'sBook` : ArmorSmithing(
    NamespacedKey.minecraft("artemis_book"),
    `Artemis'sBook`,
    3,
    true
) {
    init {
        shape(
            "   ",
            " 11",
            " 12"
        )
        setIngredient('1', Material.PAPER)
        setIngredient('2', Material.ARROW)
    }

    object `Artemis'sBook` : Item(
        ItemStack(Material.ENCHANTED_BOOK)
    ) {
      init {

          itemMeta = itemMeta.apply {
              (this as EnchantmentStorageMeta).addStoredEnchant(Enchantment.PROTECTION_PROJECTILE,1,true)
          }
      }
    }
}