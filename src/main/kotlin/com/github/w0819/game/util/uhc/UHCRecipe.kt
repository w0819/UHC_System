package com.github.w0819.game.util.uhc

import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

/**
 * UHC 레시피
 */
open class UHCRecipe(key: NamespacedKey, result: ItemStack): ShapedRecipe(key, result), UHC {
    fun register() {
        Bukkit.getServer().addRecipe(this)
    }

    override fun toString(): String {
        return this::class.simpleName ?: "anonymous"
    }
}
