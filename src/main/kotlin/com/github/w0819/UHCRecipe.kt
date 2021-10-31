package com.github.w0819

import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

open class UHCRecipe(key: NamespacedKey, result: ItemStack): ShapedRecipe(key, result) {
    fun register(): UHCRecipe {
        Bukkit.getServer().addRecipe(this)
        return this
    }
}