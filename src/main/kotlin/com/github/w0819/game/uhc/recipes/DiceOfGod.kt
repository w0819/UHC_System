package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class DiceOfGod : UHCRecipe(
    NamespacedKey.minecraft("dice_of_god"),
    Item.diceOfGod
), ExtraUltimates {
    init {
        shape(
            "121",
            "131",
            "111"
        )
        setIngredient('1', Material.MOSSY_COBBLESTONE)
        setIngredient('2',Material.PLAYER_HEAD)
        setIngredient('3',Material.JUKEBOX)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(BloodCraft(),Engineering())
    }

    override fun needCoin(): Int {
        return 100000
    }
}