package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object Daredevil :  ExtraUltimates(
    NamespacedKey.minecraft("daredevil"),
    Daredevil,
    150000,
    "BloodCraft","Engineering","Hunter"
) {
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
    object Daredevil : Item(
        ItemStack(Material.HORSE_SPAWN_EGG)
    )
}