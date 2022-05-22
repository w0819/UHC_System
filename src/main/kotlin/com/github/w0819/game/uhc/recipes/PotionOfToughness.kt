package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Survivalism
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object PotionOfToughness : Survivalism(
    NamespacedKey.minecraft("potion_of_toughness"),
    PotionOfToughness,
    3,
    true
){
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.SLIME_BALL)
        setIngredient('2',Material.SNOW_BLOCK)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
    object PotionOfToughness : Item(
        ItemStack(Material.POTION)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as PotionMeta).addCustomEffect(PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,2400,2),true)
            }
        }
    }
}