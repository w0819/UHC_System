package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Hunter
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object Fenrir : Hunter(
    NamespacedKey.minecraft("fenrir"),
    Fenrir,
    1,
    true
){
    init {
        shape(
            "111",
            "232",
            "111"
        )
        setIngredient('1', Material.LEATHER)
        setIngredient('2',Material.BONE)
        setIngredient('3',Material.EXPERIENCE_BOTTLE)
    }
    object Fenrir : Item(
        ItemStack(Material.WOLF_SPAWN_EGG)
    )
}