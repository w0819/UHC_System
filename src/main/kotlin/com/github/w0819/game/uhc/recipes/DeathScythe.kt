package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey

class DeathScythe: UHCRecipe(
    NamespacedKey.minecraft("death_scythe"),
    Item.Death_Scythe
),ExtraUltimates {
    init {
        shape(
            " 11",
            " 23",
            " 2 "
        )
        setIngredient('1', Material.PLAYER_HEAD)
        setIngredient('2',Material.BONE)
        setIngredient('3',Material.CLOCK)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(BloodCraft(),WeaponSmithing())
    }

    override fun needCoin(): Int {
        TODO("Not yet implemented")
    }
}