package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Cooking
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object HolyWater : Cooking(
    NamespacedKey.minecraft("holy_water"),
    HolyWater,
    3,
    true
){
    init {
        shape(
            "121",
            " 3 ",
            " 4 "
        )
        setIngredient('1', Material.GOLD_INGOT)
        setIngredient('2',Material.REDSTONE_BLOCK)
        setIngredient('3',Material.MUSIC_DISC_11)
        setIngredient('4',Material.GLASS_BOTTLE)
        setIngredient('3',Material.MUSIC_DISC_13)
        setIngredient('3',Material.MUSIC_DISC_CAT)
        setIngredient('3',Material.MUSIC_DISC_CHIRP)
        setIngredient('3',Material.MUSIC_DISC_FAR)
        setIngredient('3',Material.MUSIC_DISC_MALL)
        setIngredient('3',Material.MUSIC_DISC_MELLOHI)
        setIngredient('3',Material.MUSIC_DISC_PIGSTEP)
        setIngredient('3',Material.MUSIC_DISC_STAL)
        setIngredient('3',Material.MUSIC_DISC_STRAD)
        setIngredient('3',Material.MUSIC_DISC_WAIT)
        setIngredient('3',Material.MUSIC_DISC_WARD)
    }
    object HolyWater : Item(
        ItemStack(Material.POTION)
    ) {
        init {
            itemMeta = itemMeta.apply {
                (this as PotionMeta).addCustomEffect(
                    PotionEffect(PotionEffectType.ABSORPTION,2400,4)
                ,true)
            }
        }
    }
}