package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Hunter
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object PotionOfVelocity : Hunter(
    NamespacedKey.minecraft("potion_of_velocity"),
    PotionOfVelocity,
    3,
    true
){
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1',Material.BROWN_DYE)
        setIngredient('2',Material.SUGAR)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
    object PotionOfVelocity : Item(
        ItemStack(Material.SPLASH_POTION)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as PotionMeta).addCustomEffect(
                    PotionEffect(PotionEffectType.SPEED,1000,1)
                ,true)
            }
        }
    }
}