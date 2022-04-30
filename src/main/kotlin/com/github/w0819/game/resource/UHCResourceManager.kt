package com.github.w0819.game.resource

import com.github.w0819.game.util.ConfigUtil
import com.github.w0819.game.util.PlayerData
import com.github.w0819.game.util.uhc.UHC
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.plugin.UHCPlugin
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.persistence.PersistentDataType

open class UHCResourceManager : UHC {
    companion object: UHCResourceManager()

    val coinsKey = NamespacedKey.minecraft("coins")
    private val modKey = NamespacedKey.minecraft("mod_s")
    private val recipesKey = NamespacedKey.minecraft("recipes")

    private fun modes(player: Player): Int {
        if (!player.persistentDataContainer.has(modKey, PersistentDataType.INTEGER)) {
            player.persistentDataContainer.set(modKey,PersistentDataType.INTEGER,1)
        }
        return player.persistentDataContainer.get(modKey, PersistentDataType.INTEGER)!!
    }

    fun getModes(player: Player): Int {
        return player.persistentDataContainer.get(modKey,PersistentDataType.INTEGER)!!
    }

    fun switchModes(player: Player) {
        val modes = modes(player)
        player.persistentDataContainer.set(modKey,PersistentDataType.INTEGER,modes + 1)
        if (modes == 3) {
            player.persistentDataContainer.set(modKey,PersistentDataType.INTEGER,1)
        }
    }

    fun addCoin(player: Player, amount: Int) {
        val data = UHCPlugin.PlayersUHC.computeIfAbsent(player.uniqueId) { PlayerData(player.uniqueId) }
        data.coins += amount
        ConfigUtil.savePlayerCoin(player, data)
    }

    /**
     * @return true if successfully added, false if the recipe already existed
     */
    fun addRecipe(player: Player, recipe: UHCRecipe): Boolean {
        val data = UHCPlugin.PlayersUHC.computeIfAbsent(player.uniqueId) { PlayerData(player.uniqueId) }

        if (!data.uhcList.any { it is UHCRecipe && it.key == recipe.key }) {
            data.uhcList.add(recipe)
        } else {
            return false
        }
        ConfigUtil.savePlayerUHC(player, data)
        return true
    }
}