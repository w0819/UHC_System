package com.github.w0819.main

import com.github.w0819.Item
import com.github.w0819.event.Event
import net.kyori.adventure.text.Component.text
import net.projecttl.inventory.gui.gui
import net.projecttl.inventory.gui.utils.InventoryType
import org.bukkit.*
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin(){
    companion object {
        lateinit var instance: Main
            private set
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(Event(this),this)
        recipe()
        server.logger.info("Recipe is onEnable")
    }
    override fun onDisable() {
        server.logger.info("Recipe is onDisable")

    }
    private fun recipe() {
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("notch_apple"),
                Item.notchApple
            ).apply {
                shape("111","121","111")
                setIngredient('1', Material.GOLD_BLOCK)
                setIngredient('2', Material.APPLE)
            }
        )
        server.addRecipe(
        ShapedRecipe (
        NamespacedKey.minecraft("dragon_sword"),
        Item.dragon_sword
        ).apply {
            shape(
                " 1 ",
                " 2 ",
                "313"
            )
            setIngredient('1',Material.OBSIDIAN)
            setIngredient('2',Material.DIAMOND_SWORD)
            setIngredient('3',Material.BLAZE_POWDER)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("golden_head"),
                Item.golden_head
            ).apply {
                shape(
                    "111",
                    "121",
                    "111"
                )
                setIngredient('1', Material.GOLD_INGOT)
                setIngredient('2', Material.PLAYER_HEAD)
            }
        )
        server.addRecipe(
            ShapedRecipe(
                NamespacedKey.minecraft("iron_bundle"),
                ItemStack(Material.IRON_INGOT,8)
            ).apply {
                shape(
                    "111",
                    "121",
                    "111"
                )
                setIngredient('1', Material.IRON_ORE)
                setIngredient('2', Material.COAL)
            }
        )
    }
}

fun Player.openRecipeStore(plugin: Main) {
    this.gui(plugin,InventoryType.CHEST_9,text("Store")) {
        slot(0,Item.notchApple.apply {
            editMeta {
                displayName(text("노치의 블럭황금사과"))
            }
        })
        slot(1,Item.golden_head.apply { 
            editMeta { 
                displayName(text("금 머리"))
            }
        })
        slot(2,Item.dragon_sword.apply { 
            editMeta { 
                displayName(text("드레곤 소드"))
            }
        })
    }
}