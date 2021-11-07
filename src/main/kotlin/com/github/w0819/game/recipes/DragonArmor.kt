package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class DragonArmor : UHCRecipe(
    NamespacedKey.minecraft("dragon_armor"),
    Item.dragon_armor
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            "343"
        )
        setIngredient('1', Material.MAGMA_CREAM)
        setIngredient('2', Material.DIAMOND_CHESTPLATE)
        setIngredient('3', Material.OBSIDIAN)
        setIngredient('4', Material.ANVIL)
    }
}