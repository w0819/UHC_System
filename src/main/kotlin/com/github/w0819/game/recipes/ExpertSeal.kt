package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ExpertSeal : UHCRecipe(
    NamespacedKey.minecraft("expert_seal"),
    Item.ExpertSeal
){
    init {
        shape(
            "121",
            "343",
            "121"
        )
        setIngredient('1', Material.EXPERIENCE_BOTTLE)
        setIngredient('2',Material.IRON_BLOCK)
        setIngredient('3',Material.GOLD_BLOCK)
        setIngredient('4',Material.DIAMOND_BLOCK)
    }
}