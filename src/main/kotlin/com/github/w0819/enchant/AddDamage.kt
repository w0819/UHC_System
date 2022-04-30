package com.github.w0819.enchant

import org.bukkit.inventory.ItemStack

object AddDamage : EnchantmentWrapper("add_damage","AddDamage", 100) {
    override fun canEnchantItem(item: ItemStack): Boolean {
        return true
    }
}