package com.github.w0819.game

import com.github.w0819.game.team.UHCTeam
import com.github.w0819.game.timer.StartAction
import com.github.w0819.game.timer.UHCTimer
import com.github.w0819.game.util.ConfigUtil
import com.github.w0819.game.util.GameStatus
import com.github.w0819.game.util.RecipeBook
import com.github.w0819.game.util.TeamUtil
import com.github.w0819.game.util.uhc.UHC
import com.github.w0819.game.util.uhc.UHCModifier
import com.github.w0819.game.world.UHCWorld
import com.github.w0819.game.world.UHCWorldManager
import com.github.w0819.plugin.UHCPlugin
import kotlinx.coroutines.CancellationException
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class UHCGame private constructor(
    @Suppress("WeakerAccess") val players: MutableList<Player>
) : UHC {
    companion object {
        @JvmStatic
        fun create(players: List<Player>): UHCGame {
            return UHCGame(players.toMutableList()).apply {
                UHCPlugin.games.add(this)
            }
        }

        const val PLAYERS_PER_TEAM = 3
    }

    lateinit var uhcWorld: UHCWorld

    var gameStatus: GameStatus = GameStatus.BEFORE_START
        private set

    @Suppress("WeakerAccess")
    lateinit var timer: UHCTimer
        private set

    var teamGame: Boolean = false
        private set

    lateinit var teams: List<UHCTeam>
        private set

    lateinit var modifier: UHCModifier
        private set

    fun modifyGameStatus(newStatus: GameStatus) {
        if (newStatus.index > gameStatus.index) {
            gameStatus = newStatus
        }
    }

    fun addPlayer(player: Player) {
        players.add(player)
        player.removePotionEffect(PotionEffectType.HEALTH_BOOST)
        player.inventory.apply {
            addItem(getItem(4) ?: ItemStack(Material.AIR))
            setItem(4, RecipeBook.RecipeBook)
        }
        player.addPotionEffect(PotionEffect(PotionEffectType.HEALTH_BOOST,1000000000,4,true,true,true))
        ConfigUtil.playersDefaultConfig(player)
    }

    fun removePlayer(player: Player): Boolean {
        // ???????????? ??????
        return players.remove(player)
    }

    fun startGame(teamGame: Boolean, vararg startActions: StartAction<*>) {
        // UHC ?????? ??????
        Bukkit.getLogger().info("Generating World....")
        uhcWorld = UHCWorldManager.generateWorld()
        Bukkit.getLogger().info("Generate Complete!")
        
        // ????????? ??????
        timer = UHCTimer(this, startActions)
        timer.initTimer()
        
        // Modifier ??????
        modifier = UHCModifier.selectModifier(players)

        this.teamGame = teamGame

        // ????????? ??????
        teams = if (teamGame) {
            UHCTeam.divide(players, PLAYERS_PER_TEAM)   // TODO ???????????? ?????? ??????????????? ???????????? ??????
        } else {
            // ???????????? ?????? ??? ?????? ??? ???
            UHCTeam.divide(players, 1)
        }
        
        // ????????????!
        TeamUtil.spreadTeams(teams, uhcWorld.overworld)
    }

    fun stopGame(exception: CancellationException? = null) {
        // ????????? ??????
        timer.cancelTimer(exception)
    }
}