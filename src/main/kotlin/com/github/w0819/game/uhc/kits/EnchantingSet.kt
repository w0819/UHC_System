package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.UHCKit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.EnchantmentStorageMeta

class EnchantingSet : UHCKit(
    arrayListOf( // Kit
        ItemStack(Material.BOOK,2),
        ItemStack(Material.EXPERIENCE_BOTTLE,7)
    ),
    arrayListOf( // Tier I
        ItemStack(Material.BOOK,2),
        ItemStack(Material.EXPERIENCE_BOTTLE,10)
    ),
    arrayListOf( // Tier II
        ItemStack(Material.BOOK,3),
        ItemStack(Material.EXPERIENCE_BOTTLE,13),
        ItemStack(Material.LAPIS_LAZULI,12)
    ),
    arrayListOf( // Tier III
        ItemStack(Material.BOOK,4),
        ItemStack(Material.EXPERIENCE_BOTTLE,15),
        ItemStack(Material.LAPIS_LAZULI,18),
        ItemStack(Material.STONE_PICKAXE,1).apply {
            itemMeta = itemMeta.apply {
                addEnchantment(Enchantment.DIG_SPEED,3)
                addEnchantment(Enchantment.DURABILITY,1)
            }
        }
    ),
    arrayListOf( // Prestige
        ItemStack(Material.OBSIDIAN,listOf(1,2,3,4).random()),
        ItemStack(
            Material.ENCHANTED_BOOK.apply {
                val enchant = Enchantment.values().random()
                val level = (1..enchant.maxLevel).random()
                (this as? EnchantmentStorageMeta)?.addStoredEnchant(
                     enchant,
                     level,
                    true
                )
            }
        )
    )
)