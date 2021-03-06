package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.BloodCraft
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object Panacea : BloodCraft(
    NamespacedKey.minecraft("panacea"),
    Panacea,
    3,
    true
){
    init {
        shape(
            "   ",
            "121",
            " 3 "
        )
        setIngredient('1',Material.PLAYER_HEAD)
        setIngredient('2',Material.GLISTERING_MELON_SLICE)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
    object Panacea : Item(
        ItemStack(Material.POTION)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as PotionMeta).addCustomEffect(
                    PotionEffect(PotionEffectType.HEAL,20,2)
                ,true)
            }
        }
    }
}