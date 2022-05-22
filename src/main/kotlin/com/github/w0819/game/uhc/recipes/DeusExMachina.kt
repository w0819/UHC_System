package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object DeusExMachina : ExtraUltimates(
    NamespacedKey.minecraft("deus_ex_machina"),
    DeusExMachina,
    100000,
    "BloodCraft","Alchemy","Cooking"
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.EMERALD)
        setIngredient('2',Material.PLAYER_HEAD)
        setIngredient('3',Material.GLASS_BOTTLE)
    }

    object DeusExMachina : Item(
        ItemStack(Material.POTION)
    ) {
        init {
            (this.itemMeta as PotionMeta).addCustomEffect(
                PotionEffect(
                    PotionEffectType.DAMAGE_RESISTANCE,300,4
                ),true
            )
        }
    }


}