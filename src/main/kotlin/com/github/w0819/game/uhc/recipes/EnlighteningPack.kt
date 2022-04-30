package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.uhc.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class EnlighteningPack : UHCRecipe(
    NamespacedKey.minecraft("enlightening_pack"),
    ItemStack(Material.EXPERIENCE_BOTTLE,8)
){
    init {
        shape(
            " 1 ",
            "121",
            " 1 "
        )
        setIngredient('1',Material.REDSTONE_BLOCK)
        setIngredient('2',Material.GLASS_BOTTLE)
    }
}