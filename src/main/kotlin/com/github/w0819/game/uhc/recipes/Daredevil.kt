package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class Daredevil : UHCRecipe(
    NamespacedKey.minecraft("daredevil"),
    ItemStack(Material.HORSE_SPAWN_EGG)
),ExtraUltimates{
    init {
        shape(
            "12 ",
            "333",
            "3 3"
        )
        setIngredient('1',Material.PLAYER_HEAD)
        setIngredient('2',Material.SADDLE)
        setIngredient('3',Material.BONE)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(BloodCraft(),Engineering(),Hunter())
    }

    override fun needCoin(): Int {
        return 150000
    }
}