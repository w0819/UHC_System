package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object DiceOfGod : ExtraUltimates(
    NamespacedKey.minecraft("dice_of_god"),
    DiceOfGod,
    100000,
    "BloodCraft","Engineering"
) {
    init {
        shape(
            "121",
            "131",
            "111"
        )
        setIngredient('1', Material.MOSSY_COBBLESTONE)
        setIngredient('2',Material.PLAYER_HEAD)
        setIngredient('3',Material.JUKEBOX)
    }
    object DiceOfGod : Item(
        ItemStack(Material.END_PORTAL_FRAME)
    )
}