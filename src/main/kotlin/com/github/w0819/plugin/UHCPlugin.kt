package com.github.w0819.main

import com.github.w0819.StartAction
import com.github.w0819.StartActionType
import com.github.w0819.UHCGame
import com.github.w0819.UHCRecipe
import com.github.w0819.event.Event
import io.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        @JvmStatic
        val recipeList = ArrayList<UHCRecipe>()
    }

    override fun onEnable() {
        server.pluginManager.registerEvents(Event(this), this)
        server.logger.info("Recipe is enabled")
        recipeList.addAll(UHCRecipe.registerAll("com.github.w0819.recipes"))

        val game = UHCGame()

        kommand {
            register("uhc") {
                requires { isPlayer }
                executes {
                    game.startGame(StartAction(StartActionType.COUNTDOWN, 5))
                }
            }
        }
    }

}