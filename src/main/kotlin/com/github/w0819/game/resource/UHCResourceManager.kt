package com.github.w0819.game.resource

import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.plugin.UHCPlugin
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.persistence.PersistentDataType

open class UHCResourceManager {
    companion object: UHCResourceManager()

    private val coinsKey = NamespacedKey.minecraft("coins")
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
            player.persistentDataContainer.set(modKey,PersistentDataType.INTEGER,0)
        }
    }

    @SuppressWarnings("WeakerAccess")
    fun coin(player: Player): Int {
        if (!player.persistentDataContainer.has(coinsKey,PersistentDataType.INTEGER)) {
            player.persistentDataContainer.set(coinsKey, PersistentDataType.INTEGER, 0)
        }
        return player.persistentDataContainer.get(coinsKey, PersistentDataType.INTEGER)!!
    }

    private fun recipeIds(player: Player): IntArray {
        if (!player.persistentDataContainer.has(recipesKey, PersistentDataType.INTEGER_ARRAY)) {
            player.persistentDataContainer.set(recipesKey, PersistentDataType.INTEGER_ARRAY, intArrayOf())
        }
        return player.persistentDataContainer.get(recipesKey, PersistentDataType.INTEGER_ARRAY)!!

    }

    fun recipe(player: Player): List<UHCRecipe> {
        val ids = recipeIds(player)

        return ids.map { id -> UHCPlugin.recipeList[id] }
    }

    fun addCoin(player: Player, amount: Int) {
        val coins = coin(player)

        player.persistentDataContainer.set(coinsKey, PersistentDataType.INTEGER, coins + amount)
    }

    fun addRecipe(player: Player, recipe: UHCRecipe) {
        val ids = arrayListOf(*recipeIds(player).toTypedArray())
        ids.add(UHCPlugin.recipeList.indexOf(recipe))
        player.persistentDataContainer.set(recipesKey, PersistentDataType.INTEGER_ARRAY, ids.toIntArray())
    }
}