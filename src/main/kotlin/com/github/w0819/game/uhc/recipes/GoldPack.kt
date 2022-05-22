package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Invention
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object GoldPack : Invention(
    NamespacedKey.minecraft("gold_pack"),
    GoldPack,
    3,
    true
){
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.GOLD_ORE)
        setIngredient('2', Material.COAL)
    }
    object GoldPack : Item(
        ItemStack(Material.GOLD_INGOT,8)
    )
}