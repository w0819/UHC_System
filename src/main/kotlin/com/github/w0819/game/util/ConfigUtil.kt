package com.github.w0819.game.util

import com.github.w0819.plugin.UHCPlugin
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player

/**
 * UHC 의 configuration 을 담당
 */
object ConfigUtil {
    lateinit var config: FileConfiguration
    const val PlayersUHCListName = "PlayersUHCList"
    const val PlayersCoinName = "PlayersCoin"

    tailrec fun playersDefaultConfig(player: Player): ConfigurationSection {
        if (!config.contains(player.name)) {
            UHCPlugin.PlayersUHC[player.uniqueId] = PlayerData(player.uniqueId)
            return config.createSection(player.name).apply {
                set(PlayersUHCListName, listOf<String>())
                set(PlayersCoinName, 0)
            }
        }

        return config.getConfigurationSection(player.name) ?: playersDefaultConfig(player)
    }

    // 플레이어 정보 저장
    tailrec fun savePlayers(players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        savePlayerConfig(player)
        savePlayers(players - player)
    }

    tailrec fun loadPlayers(config: FileConfiguration, players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        loadPlayerConfig(player)
        loadPlayers(config, players - player)
    }

    // From here, utility functions
    fun savePlayerUHC(player: Player, data: PlayerData) {
        playersDefaultConfig(player)
            .set(PlayersUHCListName, data.uhcList.map { it.toString() })
    }

    fun loadPlayerUHC(player: Player, data: PlayerData): PlayerData {
        val playerUHCList = (playersDefaultConfig(player).getList(PlayersUHCListName) ?: return data)
            .filterIsInstance<String>()
            .mapNotNull { UHCPlugin.UHCList.find { uhc -> uhc.toString() == it } }

        data.uhcList.clear()
        data.uhcList.addAll(playerUHCList)

        return data
    }

    fun savePlayerCoin(player: Player, data: PlayerData) {
        playersDefaultConfig(player)
            .set(PlayersCoinName, data.coins)
    }

    fun loadPlayerCoin(player: Player, data: PlayerData): PlayerData {
        val playerCoin = (playersDefaultConfig(player).getInt(PlayersCoinName))
        data.coins = playerCoin
        return data
    }

    fun loadPlayerConfig(player: Player) {
        val data = UHCPlugin.PlayersUHC.computeIfAbsent(player.uniqueId) { PlayerData(player.uniqueId) }

        loadPlayerCoin(player, data)
        loadPlayerUHC(player, data)
    }

    fun savePlayerConfig(player: Player) {
        val data = UHCPlugin.PlayersUHC.computeIfAbsent(player.uniqueId) { PlayerData(player.uniqueId) }

        savePlayerCoin(player, data)
        savePlayerUHC(player, data)
    }
}