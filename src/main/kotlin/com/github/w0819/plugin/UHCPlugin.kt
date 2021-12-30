package com.github.w0819.plugin

import com.github.w0819.game.timer.StartAction
import com.github.w0819.game.timer.StartActionType
import com.github.w0819.game.UHCGame
import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.event.SystemEvent
import com.github.w0819.event.alwaysCallingFunction
import com.github.w0819.game.util.Item
import com.github.w0819.game.util.choiceKitItemGive
import com.github.w0819.game.util.randomModifierChoice
import io.github.monun.kommand.getValue
import io.github.monun.kommand.kommand
import net.kyori.adventure.text.Component
import net.projecttl.inventory.gui.SimpleInventoryBuilder
import net.projecttl.inventory.util.InventoryType
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.plugin.java.JavaPlugin

class UHCPlugin : JavaPlugin() {
    companion object {
        @JvmStatic
        val recipeList = ArrayList<UHCRecipe>()

        @JvmStatic
        lateinit var game: UHCGame
            private set

        @JvmStatic
        lateinit var instance: UHCPlugin
            private set
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(SystemEvent(this), this)
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
                    for (i in game.players) {
                        choiceKitItemGive(i)
                        randomModifierChoice(i)
                    }
                }
                then("kick" to player()) {
                    executes {
                        val kick: Player by it
                        game.removePlayer(kick)
                    }
                }
            }
        }
        alwaysCallingFunction()
    }
    /**
     * ????
     *
     * */
    private fun organizePages(player: Player) {
        val a = SimpleInventoryBuilder(player, InventoryType.CHEST_36, Component.text("UHC shop"))
        val b = SimpleInventoryBuilder(player,InventoryType.CHEST_54, Component.text("UHC Champions Shop"))
        lateinit var inventory: Inventory
        a.apply {
            slot(12,Item.apple)
            slot(14,Item.carrot)
            slot(31,Item.close)
            slot(32,Item.settings)
        }
        b.apply {
            slot(20,Item.kits)
            slot(22,Item.Professions)
        }
        var page = 0
    }
}
