package com.github.w0819.util

import com.github.w0819.UHCRecipe
import com.github.w0819.main.Main
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.persistence.PersistentDataType

open class UHCResourceManager {
    companion object: UHCResourceManager()

    private val coinsKey = NamespacedKey.minecraft("coins")
    private val recipesKey = NamespacedKey.minecraft("recipes")

    @SuppressWarnings("WeakerAccess")
    fun coin(player: Player): Int {
        if (!player.persistentDataContainer.has(coinsKey, PersistentDataType.INTEGER)) {
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

        return ids.map { id -> Main.recipeList[id] }
    }

    fun addCoin(player: Player, amount: Int) {
        val coins = coin(player)

        player.persistentDataContainer.set(coinsKey, PersistentDataType.INTEGER, coins + amount)
    }

    fun addRecipe(player: Player, recipe: UHCRecipe) {
        val ids = arrayListOf(*recipeIds(player).toTypedArray())
        ids.add(Main.recipeList.indexOf(recipe))
        player.persistentDataContainer.set(recipesKey, PersistentDataType.INTEGER_ARRAY, ids.toIntArray())
    }
}