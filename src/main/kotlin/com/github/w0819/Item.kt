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
            displayName(text("dragon sword").decorate(TextDecoration.BOLD))
            setLocalizedName("damage is 8")
        }
    }
    val golden_head = ItemStack(Material.ENCHANTED_GOLDEN_APPLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("GOLDEN HEAD!!!").decorate(TextDecoration.BOLD))
        }
    }
    val apprentice_Helmet = ItemStack(Material.IRON_HELMET).apply {
        itemMeta = itemMeta.apply {
            displayName(text("apprentice Helmet").decorate(TextDecoration.BOLD))
            addEnchantment(Enchantment.PROTECTION_FIRE,1)
            addEnchantment(Enchantment.PROTECTION_EXPLOSIONS,1)
            addEnchantment(Enchantment.PROTECTION_PROJECTILE,1)
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1)
        }
    }
    val apprentice_Sword = ItemStack(Material.IRON_INGOT).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Apprentice Sword").decorate(TextDecoration.BOLD))
        }
    }
    val apprentice_Bow = ItemStack(Material.BOW).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Apprentice Bow").decorate(TextDecoration.BOLD))
        }
    }
    val tarnhelm = ItemStack(Material.DIAMOND_HELMET).apply {
        itemMeta = itemMeta.apply {
            displayName(text("Tarnhelm").decorate(TextDecoration.BOLD))
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1)
            addEnchantment(Enchantment.PROTECTION_FIRE,1)
            addEnchantment(Enchantment.WATER_WORKER,3)
        }
    }
}
