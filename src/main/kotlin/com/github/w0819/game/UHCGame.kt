package com.github.w0819.game

import com.github.w0819.game.team.UHCTeam
import com.github.w0819.game.timer.StartAction
import com.github.w0819.game.timer.UHCTimer
import com.github.w0819.game.util.GameStatus
import com.github.w0819.game.util.GameUtils
import com.github.w0819.game.util.UHC
import com.github.w0819.game.world.UHCWorld
import com.github.w0819.game.world.UHCWorldManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.concurrent.CompletableFuture

class UHCGame private constructor(
    @Suppress("WeakerAccess") val players: MutableList<Player>
) : UHC{
    companion object {
        @JvmStatic
        fun create(players: List<Player>): UHCGame {
            return UHCGame(players.toMutableList())
        }

        const val PLAYERS_PER_TEAM = 3
        const val GameName: String = "UHC"
    }

    var uhcWorld: UHCWorld? = null
        private set(value) {
            if (value == null)
                return
            field = value
        }

    var gameStatus: GameStatus = GameStatus.BEFORE_START
        private set

    @Suppress("WeakerAccess")
    lateinit var timer: UHCTimer
        private set

    var teams: List<UHCTeam>? = null
        private set

    fun modifyGameStatus(newStatus: GameStatus) {
        if (newStatus.index > gameStatus.index) {
            gameStatus = newStatus
        }
    }

    fun addPlayer(player: Player) {
        players.add(player)
    }

    fun removePlayer(player: Player): Boolean {
        return players.remove(player)
    }

    fun startGame(teamGame: Boolean,vararg startActions: StartAction<*>): CompletableFuture<Void> {
        val future = CompletableFuture<Void>()
        Bukkit.getLogger().info("Generating World....")
        UHCWorldManager.generateWorld().thenAccept {
            uhcWorld = it
            Bukkit.getLogger().info("Generate Complete!")
            timer = UHCTimer(this, startActions)
            timer.initTimer()
            future.complete(null)
            if (teamGame) {
                teams = UHCTeam.divide(players, PLAYERS_PER_TEAM)
                GameUtils.spreadTeams(teams ?: return@thenAccept, it.overworld)
            }
        }

        return future
    }

    fun stopGame() {
        timer.cancelTimer()

    }
}