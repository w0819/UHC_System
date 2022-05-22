package com.github.w0819.game.util

import com.github.w0819.game.util.uhc.UHC
import com.github.w0819.game.util.uhc.UHCRecipe
import org.bukkit.NamespacedKey

interface Professions: UHC {
    /**
     * recipe가 상속한 [Professions]이름
     *
     * */
    val professionName: String
    companion object {
        val professions = UHC.load<Professions>("com.github.w0819.util").map { it.professionName }
    }
}

open class Apprentice(key: NamespacedKey,result: Item) : Professions,UHCRecipe(
    key,
    result,
    1,
    false
) {
    final override val professionName: String = this::class.simpleName!!
}

open class WeaponSmithing(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key,result,craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class ArmorSmithing(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class Alchemy(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class  Survivalism(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class Engineering(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class Enchanting(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class Cooking(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class BloodCraft(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class Hunter(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class ToolSmithing(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class Invention(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}

open class Strategist(key: NamespacedKey, result: Item, craftsPerGame: Int, oneMoreCraft: Boolean) : Professions,UHCRecipe(
    key, result, craftsPerGame, oneMoreCraft
) {
    final override val professionName: String = this::class.simpleName!!
}