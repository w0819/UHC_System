package com.github.w0819.game.util

import org.bukkit.Material
import org.bukkit.block.Chest
import org.bukkit.inventory.Inventory
import kotlin.random.Random


class ItemList{
    val oreList = listOf(Material.GOLD_ORE,Material.IRON_ORE,Material.LAPIS_ORE,Material.DIAMOND_ORE,Material.COAL_ORE,Material.EMERALD_ORE,Material.REDSTONE_ORE)
    val toolist = listOf(Material.DIAMOND_PICKAXE,Material.DIAMOND_SWORD,Material.DIAMOND_SHOVEL,Material.DIAMOND_AXE,Material.DIAMOND_HOE,Material.IRON_PICKAXE,Material.IRON_SWORD,Material.IRON_AXE,Material.IRON_HOE,Material.IRON_SHOVEL,Material.STONE_PICKAXE,Material.STONE_SHOVEL,Material.STONE_AXE,Material.STONE_SWORD,Material.STONE_HOE,Material.WOODEN_PICKAXE,Material.WOODEN_AXE,Material.WOODEN_HOE,Material.WOODEN_SHOVEL,Material.WOODEN_SWORD)
    val random = Random
    val int = random.nextInt()
}