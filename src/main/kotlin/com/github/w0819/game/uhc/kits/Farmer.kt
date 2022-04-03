package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.UHCKit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Farmer : UHCKit(
    arrayListOf(
        ItemStack(Material.STONE_HOE),
        ItemStack(Material.MELON_SLICE),
        ItemStack(Material.CARROT),
        ItemStack(Material.BONE_MEAL)
    ),
    arrayListOf(
        ItemStack(Material.GOLDEN_HOE),
        ItemStack(Material.MELON_SLICE),
        ItemStack(Material.CARROT),
        ItemStack(Material.BONE_MEAL,2)
    ),
    arrayListOf(
        ItemStack(Material.IRON_HOE),
        ItemStack(Material.MELON_SLICE,2),
        ItemStack(Material.CARROT,2),
        ItemStack(Material.BONE_MEAL,3)
    ),
    arrayListOf(
        ItemStack(Material.IRON_HOE),
        ItemStack(Material.MELON_SLICE,3),
        ItemStack(Material.CARROT,3),
        ItemStack(Material.BONE_MEAL,4)
    ),
    arrayListOf(
        ItemStack(Material.APPLE,(1..3).random()),
        ItemStack(Material.MELON,(1..2).random()),
        listOf(ItemStack(Material.CARROT,(2..3).random()),
            ItemStack(Material.BONE,(1..2).random())).random()
    )
)