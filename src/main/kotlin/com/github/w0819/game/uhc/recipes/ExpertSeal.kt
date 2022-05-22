package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object ExpertSeal :  ExtraUltimates(
    NamespacedKey.minecraft("expert_seal"),
    ExpertSeal,
    200000,
    "Engineering","Invention"
) {
    init {
        shape(
            "121",
            "343",
            "121"
        )
        setIngredient('1', Material.EXPERIENCE_BOTTLE)
        setIngredient('2',Material.IRON_BLOCK)
        setIngredient('3',Material.GOLD_BLOCK)
        setIngredient('4',Material.DIAMOND_BLOCK)
    }

    object ExpertSeal : Item(
        ItemStack(Material.NETHER_STAR)
    )
}