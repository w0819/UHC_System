package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Alchemy
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object Nectar : Alchemy(
    NamespacedKey.minecraft("nectar"),
    Nectar,
    3,
    true
){
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1',Material.EMERALD)
        setIngredient('2',Material.GOLD_INGOT)
        setIngredient('3',Material.MELON_SLICE)
        setIngredient('4',Material.GLASS_BOTTLE)
    }
    object Nectar : Item(
        ItemStack(Material.POTION)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as PotionMeta).addCustomEffect(
                    PotionEffect(PotionEffectType.REGENERATION,160,2)
                ,true)
            }
        }
    }
}