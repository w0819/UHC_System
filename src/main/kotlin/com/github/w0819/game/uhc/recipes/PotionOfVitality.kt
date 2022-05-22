package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object PotionOfVitality : ExtraUltimates(
    NamespacedKey.minecraft("potion_of_vitality"),
    PotionOfVitality,
    100000,
    "Survivalism","Alchemy"
){
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.PLAYER_HEAD)
        setIngredient('2',Material.NETHER_WART)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
    object PotionOfVitality : Item(
        ItemStack(Material.SPLASH_POTION)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as PotionMeta).apply {
                    addCustomEffect(PotionEffect(PotionEffectType.SPEED, 240, 2), true)
                    addCustomEffect(PotionEffect(PotionEffectType.REGENERATION, 180, 2), true)
                    addCustomEffect(PotionEffect(PotionEffectType.WEAKNESS, 240, 2), true)
                    addCustomEffect(PotionEffect(PotionEffectType.WITHER, 120, 2), true)
                }
            }
        }
    }
}