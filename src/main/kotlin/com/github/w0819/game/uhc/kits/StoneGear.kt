package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.UHCKit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class StoneGear(
    default: ArrayList<ItemStack> = arrayListOf(
        ItemStack(Material.STONE_SWORD),
        ItemStack(Material.STONE_SHOVEL),
        ItemStack(Material.STONE_AXE),
        ItemStack(Material.STONE_PICKAXE),
        ItemStack(Material.STONE_HOE)
    )
): UHCKit(
    default,
    default.onEach { if (it != ItemStack(Material.STONE_SWORD)) it.addEnchantment(Enchantment.DIG_SPEED,1) },
    default.onEach { if (it != ItemStack(Material.STONE_SWORD)) it.addEnchantment(Enchantment.DIG_SPEED,2) },
    default.onEach { if (it != ItemStack(Material.STONE_SWORD)) it.addEnchantment(Enchantment.DIG_SPEED,3);it.addEnchantment(Enchantment.DURABILITY,1) },
    arrayListOf(
        listOf(
            ItemStack(Material.IRON_SWORD),
            ItemStack(Material.IRON_SHOVEL),
            ItemStack(Material.IRON_AXE),
            ItemStack(Material.IRON_PICKAXE),
            ItemStack(Material.IRON_HOE)
        ).random().apply { if (this == ItemStack(Material.IRON_SWORD)) addEnchantment(Enchantment.LOOT_BONUS_MOBS,3) else addEnchantment(Enchantment.DIG_SPEED,3);addEnchantment(Enchantment.DURABILITY,1) }
    )
)