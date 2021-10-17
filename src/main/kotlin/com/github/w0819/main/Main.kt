package com.github.w0819.main

import com.github.w0819.Item
import com.github.w0819.command.Command
import com.github.w0819.event.Event
import org.bukkit.*
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.java.JavaPlugin
class Main : JavaPlugin(){
    companion object {
        lateinit var instance: Main
            private set
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(Event(),this)
        recipe()
        Command.recipeCommand()
    }
    private fun recipe() {
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("golden_Apple"),
                Item.notchApple
            ).apply {
                shape(
                    "ABC",
                    "DEF",
                    "GHI"
                )
                setIngredient('A', Material.GOLD_BLOCK)
                setIngredient('B', Material.GOLD_BLOCK)
                setIngredient('C', Material.GOLD_BLOCK)
                setIngredient('D', Material.GOLD_BLOCK)
                setIngredient('E', Material.APPLE)
                setIngredient('F',Material.GOLD_BLOCK)
                setIngredient('G',Material.GOLD_BLOCK)
                setIngredient('H',Material.GOLD_BLOCK)
                setIngredient('I',Material.GOLD_BLOCK)
            }
        )
        ShapedRecipe (
        NamespacedKey.minecraft("dragon_Sword"),
        Item.dragon_sword
        ).apply {
            shape(
                " A ",
                " B ",
                "CDE"
            )
            setIngredient('A',Material.OBSIDIAN)
            setIngredient('B',Material.DIAMOND_SWORD)
            setIngredient('C',Material.BLAZE_ROD)
            setIngredient('D',Material.OBSIDIAN)
            setIngredient('E',Material.BLAZE_ROD)
        }
    }
}