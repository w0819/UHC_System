package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.uhc.UHCKit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class ArcherySet : UHCKit(
    arrayListOf(
        ItemStack(Material.STRING,3),
        ItemStack(Material.FEATHER,3)
    ),
    arrayListOf(
        ItemStack(Material.STRING,4),
        ItemStack(Material.FEATHER,5)
    ),
    arrayListOf(
        ItemStack(Material.STRING,5),
        ItemStack(Material.FEATHER,7),
    ),
    arrayListOf(
        ItemStack(Material.STRING,6),
        ItemStack(Material.FEATHER,9),
        ItemStack(Material.STONE_SHOVEL).apply { addEnchantment(Enchantment.DIG_SPEED,3);addEnchantment(Enchantment.DURABILITY,1) }
    ),
    arrayListOf(
        ItemStack(Material.BONE,(1..6).random()),
        ItemStack(Material.SUGAR_CANE,(1..5).random()),
        listOf(ItemStack(Material.FLINT_AND_STEEL,(1..2).random()),ItemStack(Material.ARROW,(10..20).random())).random()
    )
)