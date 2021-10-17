package com.github.w0819

import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack





object Item {
    val notchApple = ItemStack(Material.ENCHANTED_GOLDEN_APPLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("notch Golden Apple").decorate(TextDecoration.BOLD))

        }
    }
    val dragon_sword = ItemStack(Material.DIAMOND_SWORD).apply {
        itemMeta = itemMeta.apply {
            displayName(text("dragon sword"))
            addEnchantment(Enchantment.DAMAGE_ALL,1)
        }
    }
    
}