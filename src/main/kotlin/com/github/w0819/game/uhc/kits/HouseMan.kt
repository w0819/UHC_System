package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.UHCKit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HouseMan : UHCKit(
    arrayListOf(
        ItemStack(Material.LEATHER,3),
        ItemStack(Material.SUGAR),
        ItemStack(Material.WHEAT,3)
    ),
    arrayListOf(
        ItemStack(Material.LEATHER,6),
        ItemStack(Material.SUGAR,2),
        ItemStack(Material.WHEAT,5)
    ),
    arrayListOf(
        ItemStack(Material.LEATHER,9),
        ItemStack(Material.SUGAR,3),
        ItemStack(Material.WHEAT,7),
        ItemStack(Material.STRING,1)
    ),
    arrayListOf(
        ItemStack(Material.LEATHER,12),
        ItemStack(Material.SUGAR,4),
        ItemStack(Material.HAY_BLOCK),
        ItemStack(Material.STRING,2)
    ),
    arrayListOf(
        ItemStack(Material.SADDLE,(1..2).random()),
        ItemStack(Material.DIAMOND_HORSE_ARMOR),
        ItemStack(Material.GOLDEN_CARROT,(2..4).random()),
        ItemStack(Material.HAY_BLOCK,1)
    )
)