package com.github.w0819.recipes

import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class Daredevil : UHCRecipe(
    NamespacedKey.minecraft("daredevil"),
    ItemStack(Material.HORSE_SPAWN_EGG)
){
    init {
        shape(
            "12 ",
            "333",
            "3 3"
        )
        setIngredient('1',Material.PLAYER_HEAD)
        setIngredient('2',Material.SADDLE)
        setIngredient('3',Material.BONE)
    }
}