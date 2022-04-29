package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.uhc.UHCKit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Looter : UHCKit(
    arrayListOf(
        ItemStack(Material.BONE),
        ItemStack(Material.SLIME_BALL)
    ),
    arrayListOf(
        ItemStack(Material.BONE,2),
        ItemStack(Material.SLIME_BALL,2),
        ItemStack(Material.GUNPOWDER,1)
    ),
    arrayListOf(
        ItemStack(Material.BONE,3),
        ItemStack(Material.SLIME_BALL,2),
        ItemStack(Material.GUNPOWDER,1),
        ItemStack(Material.SPIDER_EYE,1)
    ),
    arrayListOf(
        ItemStack(Material.BONE,3),
        ItemStack(Material.SLIME_BALL,3),
        ItemStack(Material.GUNPOWDER,2),
        ItemStack(Material.SPIDER_EYE,2)
    ),
    arrayListOf(
        ItemStack(Material.SPIDER_EYE,(1..3).random()),
        ItemStack(Material.INK_SAC,(1..3).random()),
        listOf(ItemStack(Material.MAGMA_CREAM,(1..2).random()), ItemStack(Material.FEATHER,(7..10).random())).random()
    )
)