package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.uhc.UHCKit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class Trapper : UHCKit(
    arrayListOf(
        ItemStack(Material.PISTON,2),
        ItemStack(Material.STICKY_PISTON,2),
        ItemStack(Material.REDSTONE,10),
        ItemStack(Material.OAK_LOG,4)
    ),
    arrayListOf(
        ItemStack(Material.PISTON,4),
        ItemStack(Material.STICKY_PISTON,4),
        ItemStack(Material.REDSTONE,15),
        ItemStack(Material.OAK_LOG,8)
    ),
    arrayListOf(
        ItemStack(Material.PISTON,8),
        ItemStack(Material.STICKY_PISTON,8),
        ItemStack(Material.REDSTONE,25),
        ItemStack(Material.OAK_LOG,16)
    ),
    arrayListOf(
        ItemStack(Material.STICKY_PISTON,(7..10).random()),
        ItemStack(Material.OAK_LOG,(12..16).random()),
        ItemStack(Material.TNT_MINECART,(1..2).random()),
        ItemStack(Material.STONE_PICKAXE).apply { addEnchantment(Enchantment.DURABILITY,3) }
    )
)