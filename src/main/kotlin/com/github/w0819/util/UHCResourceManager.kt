package com.github.w0819.util

import com.github.w0819.UHCRecipe
import org.bukkit.entity.Player

interface UHCResourceManager {
    companion object: UHCResourceManager by UHCResourceManagerImpl()

    fun coin(player: Player): Int

    fun recipe(player: Player): List<UHCRecipe>

    fun addCoin(player: Player, amount: Int)

    fun addRecipe(player: Player, recipe: UHCRecipe)
}