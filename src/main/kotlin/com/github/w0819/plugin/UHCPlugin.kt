package com.github.w0819.plugin

import com.github.w0819.enchant.AddDamage
import com.github.w0819.enchant.ReviveToken
import com.github.w0819.event.ItemEvent
import com.github.w0819.event.ModifierEvent
import com.github.w0819.event.SystemEvent
import com.github.w0819.game.UHCGame
import com.github.w0819.game.timer.StartAction
import com.github.w0819.game.timer.StartActionType
import com.github.w0819.game.util.*
import io.github.monun.kommand.getValue
import io.github.monun.kommand.kommand
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.util.*

class UHCPlugin : JavaPlugin(),UHC {
    companion object {
        @JvmStatic
        var game: UHCGame? = null
            private set

        @JvmStatic
        lateinit var instance: UHCPlugin
            private set

        @JvmStatic
        val UHCList = ArrayList<UHC>()

        @JvmStatic
        val recipeList = UHCList.filterIsInstance<UHCRecipe>()

        @JvmStatic
        val modifierList = UHCList.filterIsInstance<UHCModifier>()

        @JvmStatic
        val kitList = UHCList.filterIsInstance<UHCKit>()

        @JvmStatic
        val PlayersUHC = HashMap<UUID,List<UHC>>()
    }

    override fun onEnable() {
        val configYml = File(dataFolder,"config.yml")

        config.load(configYml)
        AddDamage.register();ReviveToken.register()
        UHCList.addAll(UHC.registerAll("com.github.w0819.game.uhc"))
        recipeList.forEach { it.register() }
        instance = this
        server.logger.info("UHC_System is enabled")

        server.pluginManager.apply {
            registerEvents(SystemEvent(this@UHCPlugin), this@UHCPlugin)
            registerEvents(ItemEvent(),this@UHCPlugin)
            registerEvents(ModifierEvent(),this@UHCPlugin)
        }

        game = UHCGame.create(listOf())

        Bukkit.getOnlinePlayers().forEach {
            game?.addPlayer(it)
        }

        kommand {
            register("uhc") {
                then("start") {
                    executes {
                        startAll()
                    }
                    then("teamGame" to bool()) {
                        executes {
                            val teamGame : Boolean by it
                            startAll(teamGame)
                        }
                    }
                }
                then("kick" to player()) {
                    executes {
                        val kick: Player by it
                        game?.removePlayer(kick)
                    }
                }
            }
        }
    }

    override fun onDisable() {
        playersUHCSave(config,Bukkit.getOnlinePlayers().toList())
    }
    private fun startAll(teamGame: Boolean = false) {
        if (game == null) {
            server.logger.info("sorry SomeThing is null please restart the server")
            return
        }
        UHCList.apply {
            removeAll(this.toSet())
            addAll(UHC.registerAll("com.github.w0819.game.uhc"))
        }
        game?.startGame(teamGame,StartAction(StartActionType.COUNTDOWN, 5))
        playersUHCLoad(config, (game ?: return).players)
        game?.uhcWorld?.returnSeed()?.forEach {
            println("${it.first}(es)s seed is ${it.second}")
        }
    }
    fun stopAll(TeamGame: Boolean) {

    }
}

