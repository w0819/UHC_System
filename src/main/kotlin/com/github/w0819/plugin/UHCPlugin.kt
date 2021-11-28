package com.github.w0819.plugin

import com.github.w0819.game.timer.StartAction
import com.github.w0819.game.timer.StartActionType
import com.github.w0819.game.UHCGame
import com.github.w0819.game.util.UHCRecipe
import com.github.w0819.event.Event
import com.github.w0819.game.recipes.ApprenticeBow
import com.github.w0819.game.recipes.ApprenticeSword
import com.github.w0819.game.resource.UHCResourceManager
import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCKits
import io.github.monun.kommand.KommandContext
import io.github.monun.kommand.getValue
import io.github.monun.kommand.kommand
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.projecttl.inventory.gui.InventoryGuiBuilder
import net.projecttl.inventory.gui.utils.InventoryType
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class UHCPlugin : JavaPlugin() {
    companion object {
        @JvmStatic
        val recipeList = ArrayList<UHCRecipe>()

        @JvmStatic
        lateinit var game: UHCGame
            private set
    }

    override fun onEnable() {
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
    private fun organizePages(player: Player) {
        val a = InventoryGuiBuilder(player,InventoryType.CHEST_36, Component.text("UHC shop"),this)
        val b = InventoryGuiBuilder(player,InventoryType.CHEST_54, Component.text("UHC Champions Shop"),this)
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
