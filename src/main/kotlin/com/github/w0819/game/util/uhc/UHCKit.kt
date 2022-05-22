package com.github.w0819.game.util.uhc

import org.bukkit.inventory.ItemStack

/**
 * 키트
 */
open class UHCKit(vararg items: ArrayList<ItemStack>) : ArrayList<ArrayList<ItemStack>>(items.toList()), UHC {
    final override fun toString(): String {
        return name
    }
}
