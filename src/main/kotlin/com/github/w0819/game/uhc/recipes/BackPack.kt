package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Invention
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object BackPack : Invention(
    NamespacedKey.minecraft("back_pack"),
    BackPack,
    1,
    true
) {
    init {
        shape(
            "121",
            "131",
            "121"
        )
        setIngredient('1', Material.STICK)
        setIngredient('2',Material.LEATHER)
        setIngredient('3',Material.CHEST)
    }
    object BackPack : Item(
        ItemStack(Material.CHEST)
    )
}