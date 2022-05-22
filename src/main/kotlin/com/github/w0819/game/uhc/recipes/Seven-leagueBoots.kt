package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Survivalism
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object `Seven-leagueBoots` : Survivalism(
    NamespacedKey.minecraft("seven_league_boots"),
    `Seven-leagueBoots`,
    1,
    true
){
    init {
        shape(
            "121",
            "131",
            "141"
        )
        setIngredient('1', Material.FEATHER)
        setIngredient('2',Material.ENDER_PEARL)
        setIngredient('3',Material.DIAMOND_BOOTS)
        setIngredient('4',Material.WATER_BUCKET)
    }
    object `Seven-leagueBoots` : Item(
        ItemStack(Material.IRON_BOOTS)
    ) {
        init {
            addEnchantment(Enchantment.PROTECTION_FIRE,3)
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3)
        }
    }
}