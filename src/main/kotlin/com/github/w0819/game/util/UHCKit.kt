package com.github.w0819.game.util

import org.bukkit.inventory.ItemStack

open class UHCKit(vararg items: ArrayList<ItemStack>) : ArrayList<ArrayList<ItemStack>>(items.toList()), UHC {

    override fun toString(): String {
        return this::class.simpleName ?: "anonymous"
    }
}
