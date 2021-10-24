package com.github.w0819

import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack


object Item {
    val notch_apple = ItemStack(Material.ENCHANTED_GOLDEN_APPLE).apply {
        itemMeta = itemMeta.apply {
            displayName(text("notch Golden Apple").decorate(TextDecoration.BOLD))
        }
    }
    val Philosopher_Pickaxe = ItemStack(Material.DIAMOND_PICKAXE,1).apply {
        itemMeta = itemMeta.apply {
            itemMeta.addEnchant(Enchantment.LURE,2,true)

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
            itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,true)
            itemMeta.addEnchant(Enchantment.PROTECTION_FIRE,1,true)
            itemMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS,1,true)
            itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE,1,true)
        }
    }
    val apprentice_Sword = ItemStack(Material.IRON_SWORD).apply {
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
            displayName(text("tarnhelm").decorate(TextDecoration.BOLD))
            itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,true)
            itemMeta.addEnchant(Enchantment.PROTECTION_FIRE,1,true)
            itemMeta.addEnchant(Enchantment.WATER_WORKER,1,true)
        }
    }

}
