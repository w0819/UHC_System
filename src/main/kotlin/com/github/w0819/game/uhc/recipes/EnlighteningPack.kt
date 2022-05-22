package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Enchanting
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object EnlighteningPack : Enchanting(
    NamespacedKey.minecraft("enlightening_pack"),
    EnlighteningPack,
    3,
    true
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
    object EnlighteningPack : Item(
        ItemStack(Material.EXPERIENCE_BOTTLE,8)
    )
}