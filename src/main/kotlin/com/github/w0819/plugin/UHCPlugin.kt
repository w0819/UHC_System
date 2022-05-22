package com.github.w0819.plugin

import com.github.w0819.enchant.AddDamage
import com.github.w0819.enchant.ReviveToken
import com.github.w0819.event.ItemEvent
import com.github.w0819.event.ModifierEvent
import com.github.w0819.event.SystemEvent
import com.github.w0819.game.UHCGame
import com.github.w0819.game.timer.StartAction
import com.github.w0819.game.timer.StartActionType
import com.github.w0819.game.util.ConfigUtil
import com.github.w0819.game.util.PlayerData
import com.github.w0819.game.util.Util
import com.github.w0819.game.util.uhc.UHC
import com.github.w0819.game.util.uhc.UHCKit
import com.github.w0819.game.util.uhc.UHCModifier
import com.github.w0819.game.util.uhc.UHCRecipe
import io.github.monun.kommand.getValue
import io.github.monun.kommand.kommand
import org.bukkit.Bukkit
import org.bukkit.World.Environment
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class UHCPlugin : JavaPlugin() {
    companion object {
        @JvmStatic
        val games = mutableListOf<UHCGame>()

        @JvmStatic
        lateinit var game: UHCGame
            private set

        @JvmStatic
        private val isGameInitialized: Boolean
            get() = ::game.isInitialized

        @JvmStatic
        lateinit var instance: UHCPlugin
            private set

        @JvmStatic
        val UHCList = ArrayList<UHC>()

        @JvmStatic
        val recipeList = { UHCList.filterIsInstance<UHCRecipe>() }

        @JvmStatic
        val modifierList = { UHCList.filterIsInstance<UHCModifier>() }

        @JvmStatic
        val kitList = { UHCList.filterIsInstance<UHCKit>() }

        @JvmStatic
        val PlayersUHC = HashMap<UUID, PlayerData>()

        @JvmStatic
        val itemList = { UHCList.filterIsInstance<UHCRecipe.Item>() }
    }

    override fun onEnable() {
        // config 셋업
        saveDefaultConfig()
        ConfigUtil.config = config

        // UHCList 에 모든 UHC 클래스를 불러온다
        UHCList.addAll(UHC.load("com.github.w0819.game.uhc"))
        println("load end")

        // UHCRecipe 를 모두 등록
        recipeList().forEach { it.register() }

        // static 객체 설정
        instance = this


        server.logger.info("UHC_System is enabled")

        // 이벤트 리스너 등록
        server.pluginManager.apply {
            registerEvents(SystemEvent(), this@UHCPlugin)
            registerEvents(ItemEvent(),this@UHCPlugin)
            registerEvents(ModifierEvent(),this@UHCPlugin)
        }

        // 게임 객체 생성
        game = UHCGame.create(listOf())

        // 기존에 접속해 있던 모든 플레이어들을 게임에 참가 시킴
        Bukkit.getOnlinePlayers().forEach { player ->
            game.addPlayer(player)
        }

        // 명령어
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
                        // 플레이어를 내보낸다
                        val kick: Player by it
                        game.removePlayer(kick)
                    }
                }
                requires { isOp }
                then("stop") {
                    executes {
                        stopAll()
                    }
                }
                then("exit") {
                    executes {
                        player.sendMessage("wait 3 second for exit the game")
                        player.sendMessage("""or you won't,chat "/exit" """)
                        val runnable = Runnable {
                            Thread.sleep(3_000)
                            Util.playerGame(player)?.players?.minus(player)
                            val world = server.getWorld("world")
                            player.teleport((world?.spawnLocation ?: return@Runnable))
                        }
                        val thread = Thread(runnable,"$player exit")
                        if (thread in Thread.getAllStackTraces()) thread.interrupt() else thread.start()
                    }
                }
            }
        }

        // 인챈트 등록
        AddDamage.register()
        ReviveToken.register()

        println(UHCList)
    }

    override fun onDisable() {
        // UHC Data 저장
        ConfigUtil.savePlayers(Bukkit.getOnlinePlayers().toList())
    }

    /**
     * 게임을 시작한다
     * @param teamGame 팀전일 경우 true, 개인전일 경우 false. 기본값은 false이다
     */
    private fun startAll(teamGame: Boolean = false) {

        // game 객체가 초기화되지 않았을때 오류 발생을 알림
        if (!isGameInitialized) {
            server.logger.severe("***The game hasn't been initialized. Please restart the server***")
            server.logger.severe("This is most likely to be a bug, please add an issue here - https://github.com/w0819/UHC_System")
            return
        }

        // UHCList 를 다시 불러온다
        UHCList.apply {
            removeAll(this.toSet())
            addAll(UHC.load("com.github.w0819.game.uhc"))
        }

        // 플레이어 정보를 불러온다
        ConfigUtil.loadPlayers(config, game.players)

        // 시드 정보 로깅
        game.uhcWorld.returnSeed().forEach {
            println("UHC's ${it.first.environment.resolve()} seed is ${it.second}")
        }

        // 게임 시작 함수 호출
        game.startGame(teamGame, StartAction(StartActionType.COUNTDOWN, 5))
    }

    // 게임을 멈춘다
    private fun stopAll() {
        ConfigUtil.savePlayers(Bukkit.getOnlinePlayers().toList())
        game.stopGame()
    }

    /**
     * Environment to vanilla world type
     * @return Vanilla world type
     */
    private fun Environment.resolve(): String {
        return when (this) {
            Environment.NORMAL -> "overworld"
            Environment.NETHER -> "nether"
            Environment.THE_END -> "end"
            Environment.CUSTOM -> "custom"
        }
    }
}

