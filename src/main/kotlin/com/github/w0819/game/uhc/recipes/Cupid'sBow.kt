package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.BloodCraft
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object `Cupid'sBow` : BloodCraft(
    NamespacedKey.minecraft("cupid_s_bow"),
    `Cupid'sBow`,
    1,
    true
){
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.BLAZE_ROD)
        setIngredient('2',Material.PLAYER_HEAD)
        setIngredient('3',Material.BOW)
        setIngredient('4',Material.LAVA_BUCKET)
        System.`in`
    }
    object `Cupid'sBow`: Item(
        ItemStack(Material.BOW)
    ) {
        init {
            addEnchantment(Enchantment.ARROW_DAMAGE,2)
            addEnchantment(Enchantment.ARROW_FIRE,1)
        }
    }
}