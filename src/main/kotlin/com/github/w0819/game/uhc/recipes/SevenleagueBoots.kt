package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.uhc.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class SevenleagueBoots : UHCRecipe(
    NamespacedKey.minecraft("seven_league_boots"),
    Item.SevenleagueBoots
){
    init {
        shape(
            "121",
            "131",
            "141"
        )
        setIngredient('1', Material.FEATHER)
        setIngredient('2',Material.ENDER_PEARL)
        setIngredient('3',Material.DIAMOND_BOOTS)
        setIngredient('4',Material.WATER_BUCKET)
    }
}