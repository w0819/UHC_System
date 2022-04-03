package com.github.w0819.game.uhc.kits

import com.github.w0819.game.util.UHCKit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LunchBox : UHCKit(
    arrayListOf(
        ItemStack(Material.COOKED_BEEF,3),
        ItemStack(Material.APPLE)
    ),
    arrayListOf(
        ItemStack(Material.COOKED_BEEF,5),
        ItemStack(Material.APPLE,2)
    ),
    arrayListOf(
        ItemStack(Material.COOKED_BEEF,7),
        ItemStack(Material.APPLE,3)
    ),
    arrayListOf(
        ItemStack(Material.COOKED_BEEF,9),
        ItemStack(Material.GOLDEN_CARROT,12),
        ItemStack(Material.MELON_SLICE,2),
        ItemStack(Material.GOLD_INGOT,2),
        ItemStack(Material.APPLE,3)
    ),
    listOf(
       arrayListOf(
           ItemStack(Material.CARROT,(10..15).random()),
           ItemStack(Material.GLISTERING_MELON_SLICE,(4..8).random()),
           ItemStack(Material.GOLD_INGOT,(2..4).random())
       ),
        arrayListOf(
            ItemStack(Material.GOLD_INGOT,(4..7).random()),
            ItemStack(Material.COCOA_BEANS,(5..8).random())
        )
    ).random()
)