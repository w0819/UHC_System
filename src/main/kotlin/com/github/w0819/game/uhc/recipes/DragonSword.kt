package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.WeaponSmithing
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object DragonSword: WeaponSmithing(
    NamespacedKey.minecraft("dragon_sword"),
    DragonSword,
    1,
    true
){
    init {
        shape(
            " 1 ",
            " 2 ",
            "313"
        )
        setIngredient('1', Material.OBSIDIAN)
        setIngredient('2', Material.DIAMOND_SWORD)
        setIngredient('3', Material.BLAZE_POWDER)
    }
    object DragonSword : Item(
        ItemStack(Material.DIAMOND_SWORD),
        listOf(
            Component.text("damage is 8")
        )
    )
}