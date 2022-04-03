package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.UHCKit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Ecologist : UHCKit(
    arrayListOf(
        ItemStack(Material.OAK_LOG,8),
        ItemStack(Material.LILY_PAD,8)
    ),
    arrayListOf(
        ItemStack(Material.OAK_LOG,16),
        ItemStack(Material.LILY_PAD,16)
    ),
    arrayListOf(
        ItemStack(Material.OAK_LOG,32),
        ItemStack(Material.LILY_PAD,32),
        ItemStack(Material.COAL,1)
    ),
    arrayListOf(
        ItemStack(Material.OAK_LOG,54),
        ItemStack(Material.LILY_PAD,64),
        ItemStack(Material.COAL,3)
    ),
    arrayListOf(
        ItemStack(Material.COAL_BLOCK,(1..2).random()),
        ItemStack(Material.EMERALD,(4..6).random()),
        listOf(ItemStack(Material.WOLF_SPAWN_EGG,1),ItemStack(Material.COW_SPAWN_EGG,(1..3).random())).random()
    )
)