package com.github.w0819.game.util

import com.github.w0819.game.util.uhc.UHCRecipe
import net.kyori.adventure.text.Component
import org.bukkit.NamespacedKey

open class ExtraUltimates(key: NamespacedKey, result: Item, val needCoin: Int, final override vararg val needProfessions: String,
): UHCRecipe(
    key,
    result,
    1,
    false
),Ultimates,Professions {
    init {
        result.lore (
            (listOf(Component.text("")) + needProfessions.map { Component.text("- $it") }),
        )
    }

    override val professionName: String = this::class.simpleName!!
}

interface Ultimates {
    val needProfessions: Array<out String>
}
