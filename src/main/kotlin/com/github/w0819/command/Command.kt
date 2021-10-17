package com.github.w0819.command

import com.github.w0819.Item
import com.github.w0819.main.Main
import io.github.monun.kommand.kommand
import org.bukkit.plugin.Plugin

object Command {
    private fun getInstance(): Plugin {
        return Main.instance
    }
    fun recipeCommand() {
        getInstance().kommand {
            register("Recipe") {
                then("give") {
                    executes {
                        player.inventory.addItem(Item.dragon_sword)
                        player.inventory.addItem(Item.notchApple)
                    }
                }
            }
        }
    }
}