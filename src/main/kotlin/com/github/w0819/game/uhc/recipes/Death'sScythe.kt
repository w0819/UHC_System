package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object `Death'sScythe`:  ExtraUltimates(
    NamespacedKey.minecraft("death_scythe"),
    `Death'sScythe`,
    200000,
    "BloodCraft","WeaponSmithing"
) {
    init {
        shape(
            " 11",
            " 23",
            " 2 "
        )
        setIngredient('1', Material.PLAYER_HEAD)
        setIngredient('2',Material.BONE)
        setIngredient('3',Material.CLOCK)
    }

    object `Death'sScythe` : Item(
        ItemStack(Material.IRON_HOE)
    )
}