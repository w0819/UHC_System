package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey

class HideOfLeviathan : UHCRecipe(
    NamespacedKey.minecraft("hide_of_leviathan"),
    Item.HideOfLeviathan

),ExtraUltimates{
    init {
        shape(
            "121",
            "343",
            "5 5"
        )
        setIngredient('1', Material.LAPIS_BLOCK)
        setIngredient('2',Material.WATER_BUCKET)
        setIngredient('3',Material.DIAMOND)
        setIngredient('4',Material.DIAMOND_LEGGINGS)
        setIngredient('5',Material.LILY_PAD)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(ArmorSmithing(),Survivalism())
    }

    override fun needCoin(): Int {
        return 150000
    }


}