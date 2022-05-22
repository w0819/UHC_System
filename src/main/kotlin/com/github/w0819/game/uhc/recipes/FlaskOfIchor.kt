package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object FlaskOfIchor :  ExtraUltimates(
    NamespacedKey.minecraft("flask_of_ichor"),
    FlaskOfIchor,
    120000,
    "Alchemy","BloodCraft"
) {
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.PLAYER_HEAD)
        setIngredient('2',Material.BROWN_MUSHROOM)
        setIngredient('3',Material.GLASS_BOTTLE)
        setIngredient('4',Material.INK_SAC)
    }

    object FlaskOfIchor : Item(
        ItemStack(Material.SPLASH_POTION)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.HARM,40,3),true)
            }
        }
    }
}