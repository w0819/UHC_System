package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object FlaskOfCleansing : ExtraUltimates(
    NamespacedKey.minecraft("flask_of_cleansing"),
    FlaskOfCleansing,
    100000,
    "Hunter","Engineering"
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.ZOMBIE_HEAD)
        setIngredient('2',Material.MILK_BUCKET)
        setIngredient('3',Material.GLASS_BOTTLE)
    }

    object FlaskOfCleansing : Item(
        ItemStack(Material.SPLASH_POTION)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as PotionMeta).addCustomEffect(
                    PotionEffect(PotionEffectType.WEAKNESS,240,2)
                ,true)
            }
        }
    }
}