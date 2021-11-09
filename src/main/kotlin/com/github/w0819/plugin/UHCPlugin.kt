package com.github.w0819.plugin

import com.github.w0819.game.timer.StartAction
import com.github.w0819.game.timer.StartActionType
import com.github.w0819.game.UHCGame
import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.event.Event
import com.github.w0819.game.recipes.ApprenticeBow
import com.github.w0819.game.recipes.ApprenticeSword
import com.github.w0819.game.util.UHCKits
import io.github.monun.kommand.getValue
import io.github.monun.kommand.kommand
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class UHCPlugin : JavaPlugin() {
    companion object {
        @JvmStatic
        val recipeList = ArrayList<UHCRecipe>()

        @JvmStatic
        lateinit var game: UHCGame
            private set
        @JvmStatic
        val kitList = ArrayList<UHCKits>()
    }

    override fun onEnable() {
        recipe()
        server.pluginManager.registerEvents(Event(this), this)
        server.logger.info("Recipe is enabled")
        recipeList.addAll(UHCRecipe.registerAll("com.github.w0819.game.recipes"))

        game = UHCGame.create(listOf())

        Bukkit.getOnlinePlayers().forEach {
            game.addPlayer(it)
        }

        kommand {
            register("uhc") {
                requires { isPlayer && isOp }
                executes {
                    game.startGame(StartAction(StartActionType.COUNTDOWN, 5))
                }
                then("kick" to player()) {
                    executes {
                        val kick: Player by it
                        game.removePlayer(kick)
                    }
                }
            }
        }
    }
}
