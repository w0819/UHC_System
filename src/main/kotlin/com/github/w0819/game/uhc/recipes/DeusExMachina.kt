package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey

class DeusExMachina : UHCRecipe(
    NamespacedKey.minecraft("deus_ex_machina"),
    Item.DeusExMachina
),ExtraUltimates{
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.EMERALD)
        setIngredient('2',Material.PLAYER_HEAD)
        setIngredient('3',Material.GLASS_BOTTLE)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(BloodCraft(),Alchemy(),Cooking())
    }

    override fun needCoin(): Int {
        return 100000
    }


}