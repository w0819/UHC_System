package com.github.w0819.game.util

import com.github.w0819.plugin.UHCPlugin
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player

/**
 * UHC 의 configuration 을 담당
 */
object ConfigUtil {
    private const val PlayersUHCListName = "PlayersUHCList"

    tailrec fun playersDefaultConfig(config: FileConfiguration, player: Player): ConfigurationSection {
        if (!config.contains(player.name)) {
            UHCPlugin.PlayersUHC[player.uniqueId] = listOf()
            return config.createSection(player.name).apply { set(PlayersUHCListName,listOf<String>()) }
        }
        return config.getConfigurationSection(player.name) ?: playersDefaultConfig(config, player)
    }

    // 플레이어 정보 저장
    fun playersUHCSave(config: FileConfiguration, players: List<Player>) {
        tailrec fun playersUHCSave (config: FileConfiguration, players: List<Player>) {
            if (players.isEmpty()) return // 플레이어 리스트가 비었으면 리턴
            val player = players[0] // 리스트의 첫 플레이어
            val playersUHC = UHCPlugin.PlayersUHC.computeIfAbsent(player.uniqueId) { listOf() } // UHC 리스트 불러오기, 없으면 생성

            // edit: 이부분 뭔가 오류가 있는듯
            (config.getConfigurationSection(player.name) ?: playersDefaultConfig(config, player))
                .set(PlayersUHCListName, playersUHC.map { it.toString() })  // 플레이어 UHC 정보 저장
            playersUHCSave(config,players - player) // 플레이어를 제거한 후 재귀
        }
        playersUHCSave(config, players)
    }

    tailrec fun playersUHCLoad(config: FileConfiguration, players: List<Player>) {
        if (players.isEmpty()) return
        val player = players[0]
        val playersUHCes = (config.getList(PlayersUHCListName) ?: listOf()).filterIsInstance<String>().mapNotNull { UHCPlugin.UHCList.find { uhc -> uhc.toString() == it } }

        UHCPlugin.PlayersUHC[player.uniqueId] = playersUHCes
        playersUHCLoad(config, players - player)
    }
}