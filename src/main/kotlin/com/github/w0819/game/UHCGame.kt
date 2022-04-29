package com.github.w0819.game

import com.github.w0819.game.team.UHCTeam
import com.github.w0819.game.timer.StartAction
import com.github.w0819.game.timer.UHCTimer
import com.github.w0819.game.util.ConfigUtil
import com.github.w0819.game.util.GameStatus
import com.github.w0819.game.util.Item
import com.github.w0819.game.util.TeamUtil
import com.github.w0819.game.util.uhc.UHC
import com.github.w0819.game.util.uhc.UHCModifier
import com.github.w0819.game.world.UHCWorld
import com.github.w0819.game.world.UHCWorldManager
import com.github.w0819.plugin.UHCPlugin
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class UHCGame private constructor(
    @Suppress("WeakerAccess") val players: MutableList<Player>
) : UHC {
    companion object {
        @JvmStatic
        fun create(players: List<Player>): UHCGame {
            return UHCGame(players.toMutableList())
        }

        const val PLAYERS_PER_TEAM = 3
        const val GameName: String = "UHC"
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
        player.inventory.setItem(4, Item.recipeBook)
        player.addPotionEffect(PotionEffect(PotionEffectType.HEALTH_BOOST,1000000000,4,true,true,true))
        ConfigUtil.playersDefaultConfig(UHCPlugin.instance.config, player)
    }

    fun removePlayer(player: Player): Boolean {
        // 플레이어 제거
        return players.remove(player)
    }

    fun startGame(teamGame: Boolean, vararg startActions: StartAction<*>) {
        // UHC 월드 생성
        Bukkit.getLogger().info("Generating World....")
        uhcWorld = UHCWorldManager.generateWorld()
        Bukkit.getLogger().info("Generate Complete!")
        
        // 타이머 설정
        timer = UHCTimer(this, startActions)
        timer.initTimer()
        
        // Modifier 선택
        modifier = UHCModifier.selectModifier(players)

        this.teamGame = teamGame

        // 팀으로 나눔
        teams = if (teamGame) {
            UHCTeam.divide(players, PLAYERS_PER_TEAM)   // TODO 밸런스에 맞게 분산시키는 알고리즘 필요
        } else {
            // 개인전의 경우 한 팀에 한 명
            UHCTeam.divide(players, 1)
        }
        
        // 퍼뜨리기!
        TeamUtil.spreadTeams(teams, uhcWorld.overworld)
    }

    fun stopGame() {
        // 타이머 멈춤
        timer.cancelTimer()
    }
}